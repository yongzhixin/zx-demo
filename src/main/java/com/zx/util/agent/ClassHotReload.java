package com.zx.util.agent;

import java.lang.instrument.Instrumentation;

public class ClassHotReload {
	public static ReloadThread reloadThread;

	public static void premain(String agentArgs, Instrumentation inst) throws Exception {
		Trace.log("是否支持类的重定义：" + inst.isRedefineClassesSupported());
		reloadThread = new ReloadThread(inst);
		reloadThread.start();
	}

}
