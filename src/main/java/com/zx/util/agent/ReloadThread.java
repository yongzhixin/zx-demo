package com.zx.util.agent;

import java.lang.instrument.Instrumentation;

public class ReloadThread extends Thread {

	private long sleepTime = 30000L;
	private Instrumentation inst;
	private GetClassFromJarCompare reload2;

	public ReloadThread(Instrumentation instrumentation) {
		this.inst = instrumentation;

		this.reload2 = new GetClassFromJarCompare(this.inst);
		setDaemon(true);
	}

	public void run() {
		try {
			for (;;) {
				Thread.sleep(this.sleepTime);
				this.reload2.reload();
			}
		} catch (Exception e) {
			Trace.log("ReloadThread error2 : ", e);
		}
	}

}
