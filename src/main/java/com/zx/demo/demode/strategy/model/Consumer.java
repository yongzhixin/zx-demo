package com.zx.demo.demode.strategy.model;

import com.zx.demo.demode.strategy.StrategyFactory;
import com.zx.demo.demode.strategy.StrategyType;

public class Consumer {

	private double total;
	private double amount;
	private StrategyType strategyType = StrategyType.COMMON;

	public void buy(double amount) {
		this.amount = amount;
		this.total += amount;
		strategyType = StrategyFactory.createStrategy(this);
		double pay = payment();
		System.out.println("最终支付：" + pay);
	}

	private double payment() {
		return strategyType.cal(amount);
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
