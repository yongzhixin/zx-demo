package com.zx.util.agent;

import sun.misc.URLClassPath;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import sun.net.util.URLUtil;

public class GetClassFromJarCompare extends IReload {

	private volatile long previousFileTime;
	private volatile boolean chrPathTip = true;
	private volatile boolean fileNotExistTip = true;

	public GetClassFromJarCompare(Instrumentation inst) {
		super(inst);
	}

	public void reload() {
		try {
			String url = System.getProperty("ClassHotReloadJarPath");
			if (url == null) {
				if (this.chrPathTip) {
					Trace.log("[ClassHotReloadJarPath] 路径没有配置!");
					this.chrPathTip = false;
				}
				return;
			}
			this.chrPathTip = true;

			File file = new File(url);
			long lastModified = file.lastModified();
			if ((!file.exists()) || (lastModified == this.previousFileTime)) {
				if (this.fileNotExistTip) {
					Trace.log("是否存在文件:" + file.exists() + "; 本次编辑时间:" + new Date(lastModified) + "; 上次编辑时间:"
							+ new Date(this.previousFileTime));
					this.fileNotExistTip = false;
				}
				return;
			}
			this.fileNotExistTip = true;

			String fileContent = getFileContent(file);
			String[] compareItems = fileContent.split("\n");
			Trace.log("存在脚本配置文件:" + file.getName() + "并且有新的更新, 本次编辑时间:" + new Date(lastModified) + "; 上次编辑时间:"
					+ new Date(this.previousFileTime));

			boolean isOk = true;
			String[] arrayOfString1;
			int j = (arrayOfString1 = compareItems).length;
			for (int i = 0; i < j; i++) {
				String item = arrayOfString1[i];
				String[] jarpaths = item.split(";");
				if (jarpaths.length == 2) {
					isOk = (compareJar(jarpaths)) && (isOk);
				}
			}
			this.previousFileTime = lastModified;
			if (isOk) {
				Trace.log("======本次重加载成功=======更新脚本为最新========等待下次重加载");
			} else {
				Trace.log("======本次重加载失败");
			}
		} catch (Exception e) {
			Trace.log("reload ", e);
		}
	}

	private boolean compareJar(String[] jarPaths) throws Exception {
		File fileOld = new File(jarPaths[0].trim());
		File fileNew = new File(jarPaths[1].trim());
		Trace.log("开始比较JAR,旧路径:" + fileOld.getAbsolutePath() + " 编辑时间:" + new Date(fileOld.lastModified()) + " 新路径:"
				+ fileNew.getAbsolutePath() + " 编辑时间:" + new Date(fileNew.lastModified()));
		if (!fileOld.exists()) {
			Trace.log("旧文件不存在:" + fileOld.getAbsolutePath());
			return true;
		}
		if (!fileNew.exists()) {
			Trace.log("新文件不存在:" + fileNew.getAbsolutePath());
			return true;
		}
		if (fileNew.lastModified() < fileOld.lastModified()) {
			Trace.log("[CHR]" + fileNew.getAbsolutePath() + " 比 " + fileOld.getAbsolutePath() + " 还要老，放弃加载");
			return true;
		}
		boolean isOk = true;
		JarFile jarOld = new JarFile(jarPaths[0].trim());
		JarFile jarNew = new JarFile(jarPaths[1].trim());
		List<Set<JarEntry>> list = JarCompare.getModifyContent(jarOld, jarNew);
		Set<JarEntry> addJarEntrySet = (Set) list.get(0);
		Trace.log("新增class列表:" + addJarEntrySet);
		if (addJarEntrySet.size() > 0) {
			URLClassLoader appClassLoader = getAppClassLoader(fileNew.toURI().toURL());
			for (JarEntry entry : addJarEntrySet) {
				String className = getclassnameFromPathformat(entry.getName());
				Trace.log("准备加载新Class:" + className);
				try {
					appClassLoader.loadClass(className);
					isOk = isOk;
					Trace.log("加载新Class成功:" + className);
				} catch (Exception e) {
					isOk = false;
					Trace.log("加载新Class失败:" + className, e);
				}
			}
		}
		Set<JarEntry> jarEntrySet = (Set) list.get(1);
		Trace.log("热更class列表:" + jarEntrySet);
		if (jarEntrySet.size() > 0) {
			for (JarEntry entry : jarEntrySet) {
				Trace.log("准备重加载:" + entry.getName());
				String className = getclassnameFromPathformat(entry.getName());
				byte[] content = getFromInputstram(jarNew.getInputStream(entry));
				isOk = (redefineClasses(Class.forName(className), content)) && (isOk);
			}
		}
		return isOk;
	}

	private URLClassLoader getAppClassLoader(URL url) throws Exception {
		URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

		Field ucpField = URLClassLoader.class.getDeclaredField("ucp");
		ucpField.setAccessible(true);
		URLClassPath ucp = (URLClassPath) ucpField.get(appClassLoader);

		Field pathField = URLClassPath.class.getDeclaredField("path");
		pathField.setAccessible(true);
		Field urlsField = URLClassPath.class.getDeclaredField("urls");
		urlsField.setAccessible(true);
		ArrayList<URL> path = (ArrayList) pathField.get(ucp);
		Stack<URL> urls = (Stack) urlsField.get(ucp);
		path.remove(url);
		urls.remove(url);

		Field loadersField = URLClassPath.class.getDeclaredField("loaders");
		loadersField.setAccessible(true);
		Field lmapField = URLClassPath.class.getDeclaredField("lmap");
		lmapField.setAccessible(true);

		ArrayList loaders = (ArrayList) loadersField.get(ucp);
		Map lmap = (Map) lmapField.get(ucp);
		String urlNoFragString = URLUtil.urlNoFragString(url);
		Object o = lmap.remove(urlNoFragString);
		if (o != null) {
			loaders.remove(o);
		}
		Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
		add.setAccessible(true);
		add.invoke(appClassLoader, new Object[] { url });

		return appClassLoader;
	}

	private static String getclassnameFromPathformat(String a) {
		return a.replace("/", ".").substring(0, a.length() - 6);
	}

}
