package com.zx.util.agent;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

public abstract class IReload {

	protected Instrumentation inst;

	public IReload(Instrumentation inst) {
		this.inst = inst;
	}

	public abstract void reload();

	protected static void transferIOStream(InputStream is, OutputStream os) throws IOException {
		int bytesRead = 0;
		byte[] buffer = new byte['a'];// FIXME
		while ((bytesRead = is.read(buffer, 0, 2048)) != -1) {
			if (os != null) {
				os.write(buffer, 0, bytesRead);
			}
		}
	}

	public byte[] getFromInputstram(InputStream is) throws IOException {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		transferIOStream(is, bao);
		return bao.toByteArray();
	}

	protected boolean redefineClasses(Class<?> clazz, byte[] clazzBytes) {
		Trace.log(" [CHR]开始重定义类,clazz : " + clazz + " clazzBytes : " + clazzBytes.length);
		if ((clazz != null) && (clazzBytes != null)) {
			try {
				Trace.log(" [CHR]开始重定义类:" + clazz.getName());
				ClassDefinition classDefine = new ClassDefinition(clazz, clazzBytes);
				this.inst.redefineClasses(new ClassDefinition[] { classDefine });
				Trace.log(" [CHR]重定义类成功:" + clazz.getName());
				return true;
			} catch (Exception e) {
				Trace.log(" [CHR]重定义类失败:" + clazz.getName(), e);
				return false;
			}
		}
		Trace.log(" [CHR]重定义类失败,clazz : " + clazz + " clazzBytes : " + clazzBytes);
		return false;
	}

	protected String getFileContent(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			transferIOStream(fis, bao);
			String str = new String(bao.toByteArray());
			return str;
		} catch (Exception e) {
			Trace.log("getFileContent error", e);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e1) {
				Trace.log("getFileContent1 error", e1);
			}
		}
		return null;
	}

}