package com.zx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	public static void main(String[] args) throws InterruptedException {

		Map<String, String[]> map = new ConcurrentHashMap<String, String[]>();

		for (int i = 1; i <= 50; i++) {
			String[] ids = new String[5];
			map.put(String.valueOf(i), ids);
		}

		Thread t1 = new Thread(new TestRun(map));
		t1.start();
//		t1.join();
		Thread t2 = new Thread(new TestRun2(map));
		t2.start();
//		t2.join();
		String[] ids = map.get("1");
		System.out.println("Main :::::: " + ids[0] + " " + ids[2] + " " + ids[4] + " " + ids);
	}

}

class TestRun implements Runnable {

	Map<String, String[]> map;

	public TestRun(Map<String, String[]> map) {
		this.map = map;
	}

	public void run() {
		String[] ids = map.get("1");
		ids[0] = "1";
		ids[2] = "5";
		System.out.println("=====read and w");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===== " + ids[0] + " " + ids[2] + " " + ids[4] + " " + ids);
	}

}

class TestRun2 implements Runnable {

	Map<String, String[]> map;

	public TestRun2(Map<String, String[]> map) {
		this.map = map;
	}

	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----read");
		String[] ids = map.get("1");
		System.out.println("-----== " + ids[0] + " " + ids[2] + " " + ids[4] + " " + ids);
		ids[0] = "0";
		ids[4] = "10";
		System.out.println("----- " + ids[0] + " " + ids[2] + " " + ids[4] + " " + ids);
	}

}