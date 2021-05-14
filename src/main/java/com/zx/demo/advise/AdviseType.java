package com.zx.demo.advise;

import com.zx.demo.advise.impl.AfterAdvise;
import com.zx.demo.advise.impl.BeforeAdvise;

/**
 * 通知类型: 处理一些具有共性的操作，类似于AOP
 * 
 * @author zhixin
 *
 */
public enum AdviseType {
	/** 前置通知 */
	BEFORE(new BeforeAdvise()),
	/** 后置通知 */
	AFTER(new AfterAdvise());

	private IAdvise advise;

	private AdviseType(IAdvise advise) {
		this.advise = advise;
	}

	/**
	 * 通知
	 */
	public void advise() {
		this.advise.advise();
	}

}
