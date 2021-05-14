package com.zx.demo.advise.impl;

import com.zx.demo.advise.IAdvise;

/**
 * 后置通知
 * 
 * @author zhixin
 *
 */
public class AfterAdvise implements IAdvise {

	public void advise() {
		System.out.println("后置通知...");
	}

}
