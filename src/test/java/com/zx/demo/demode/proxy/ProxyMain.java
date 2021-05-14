package com.zx.demo.demode.proxy;

import junit.framework.TestCase;

public class ProxyMain extends TestCase {

	public void testStaticProxy() {
		StaticProxySubject sub = new StaticProxySubject();
		sub.doSomething();
		System.out.println(sub.getClass().getName());
	}

	public void testDynamicProxy() {
		Subject proxy = DynamicProxyFactory.createProxy();
		proxy.doSomething();
		System.out.println(proxy.getClass().getName());
	}

	public void testCglibProxy() {
		Subject proxy = DynamicProxyFactory.createCglibProxy();
		proxy.doSomething();
		System.out.println(proxy.getClass().getName());
	}

}
