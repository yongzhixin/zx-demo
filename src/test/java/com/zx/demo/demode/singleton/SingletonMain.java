package com.zx.demo.demode.singleton;

import junit.framework.TestCase;

public class SingletonMain extends TestCase {

	public void testDelayLoaderSingleton() {
		Singleton instance = Singleton.getInstance();

		Singleton instance2 = Singleton.getInstance();

		System.out.println(instance == instance2);
	}

}
