package com.zx.demo.advise.impl;

import com.zx.demo.advise.IAdvise;

/**
 * 前置通知
 * 
 * @author zhixin
 *
 */
public class BeforeAdvise implements IAdvise {

	public void advise() {
		System.out.println("前置通知...");
	}

}
