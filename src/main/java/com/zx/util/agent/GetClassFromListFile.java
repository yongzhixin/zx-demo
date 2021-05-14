package com.zx.util.agent;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.net.URLConnection;

public class GetClassFromListFile extends IReload {

	private volatile long previousFileTime;

	public GetClassFromListFile(Instrumentation inst) {
		super(inst);
	}

	public void reload() {
		String url = System.getProperty("ClassHotReloadFilePath");
		if (url == null) {
			Trace.log("检查类重加载机制,未找到系统属性:ClassHotReloadFilePath 等待下次检查");
			return;
		}
		File file = new File(url);
		long lastModified = file.lastModified();
		if ((!file.exists()) || (lastModified == this.previousFileTime)) {
			return;
		}
		String fileContent = getFileContent(file);

		String[] clazzsUrlForReload = fileContent.split("\n");
		if ((clazzsUrlForReload == null) || (clazzsUrlForReload.length == 0)) {
			return;
		}
		boolean isReloadOk = true;
		String[] arrayOfString1;
		int j = (arrayOfString1 = clazzsUrlForReload).length;
		for (int i = 0; i < j; i++) {
			String clazzUrl = arrayOfString1[i];
			clazzUrl = clazzUrl.trim();

			String classname = getClassNameFromJarUrl(clazzUrl);
			byte[] clazzbytes = getFileBytes(clazzUrl);
			try {
				isReloadOk = (isReloadOk) && (redefineClasses(Class.forName(classname), clazzbytes));
			} catch (Exception e) {
				Trace.log("reload e:", e);
			}
			if (isReloadOk) {
				this.previousFileTime = lastModified;
			}
		}
	}

	private String getClassNameFromJarUrl(String a) {
		int index = a.indexOf("!/");
		if (index != -1) {
			a = a.substring(index + 2);
			if (a.endsWith(".class")) {
				a = a.substring(0, a.length() - 6).replace("/", ".");
				return a;
			}
		}
		return null;
	}

	private byte[] getFileBytes(String clazzName) {
		URLConnection connection = null;
		InputStream is = null;
		try {
			URL url = new URL(clazzName);
			connection = url.openConnection();
			is = connection.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			transferIOStream(is, baos);
			byte[] t = baos.toByteArray();
			return t;
		} catch (IOException e) {
			Trace.log("getFileBytes error", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					Trace.log("getFileBytes error", e1);
				}
			}
		}
		return null;
	}

}
