package com.zx.demo.demode.strategy.impl;

import com.zx.demo.demode.strategy.CalPriceStrategy;

public class PriceStrategy implements CalPriceStrategy {

	public double calPrice(double orgnic, double rate) {
		return orgnic * rate;
	}

	private PriceStrategy() {
	}

	public static PriceStrategy getInstance() {
		return CalPriceStrategyHolder.INSTANCE;
	}

	private static class CalPriceStrategyHolder {
		private static PriceStrategy INSTANCE = new PriceStrategy();
	}

}
