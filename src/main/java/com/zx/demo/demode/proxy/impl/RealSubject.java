package com.zx.demo.demode.proxy.impl;

import com.zx.demo.demode.proxy.Subject;

public class RealSubject implements Subject {

	public void doSomething() {
		System.out.println("real do something...");
	}

}
