package com.zx.demo.demode.strategy;

import com.zx.demo.demode.strategy.impl.PriceStrategy;

public enum StrategyType {

	/** 原价 */
	@Strategy(max = 10000) COMMON("普通", 1),
	/** vip */
	@Strategy(min = 10000, max = 20000) VIP("vip", 0.9),
	/** super_vip */
	@Strategy(min = 20000, max = 30000) SUPER_VIP("super_vip", 0.8),
	/** gold_vip */
	@Strategy(min = 30000) GOLD_VIP("gold_vip", 0.6);

	private String name;
	private CalPriceStrategy strategy;
	private double rate;

	private StrategyType(String name, double rate) {
		this.name = name;
		this.strategy = PriceStrategy.getInstance();
		this.rate = rate;
	}

	public double cal(double orgnic) {
		System.out.println(name + "用户，折扣为：" + rate);
		double price = strategy.calPrice(orgnic, rate);
		System.out.println("原价为：" + orgnic + "，折后价为：" + price + "，本次优惠：" + (orgnic - price));
		return price;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

}
