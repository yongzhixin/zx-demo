package com.zx.demo.thread;

import java.util.concurrent.TimeUnit;

public class Join {

	public static void main(String[] args) throws Exception {
		Thread preThread = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Domino(preThread), String.valueOf(i));
			thread.start();
			preThread = thread;
			System.out.println(thread.getName() + " start.");
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName() + " terminate.");
	}

	static class Domino implements Runnable {
		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		public void run() {
			try {
				System.err.println(Thread.currentThread().getName() + " join.");
				thread.join();
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}

	}

}
