package com.zx.demo.demode.proxy;

import com.zx.demo.demode.proxy.impl.RealSubject;

/**
 * 静态代理
 * 
 * @author zhixin
 *
 */
public class StaticProxySubject implements Subject {

	private RealSubject sub;

	public StaticProxySubject() {
		this.sub = new RealSubject();
	}

	public void doSomething() {
		System.out.println("执行前...");
		sub.doSomething();
		System.out.println("执行后...");
	}

}
