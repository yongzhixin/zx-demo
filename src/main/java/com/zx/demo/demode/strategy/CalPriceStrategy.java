package com.zx.demo.demode.strategy;

/**
 * 策略模式接口
 * 
 * @author zhixin
 *
 */
public interface CalPriceStrategy {

	/**
	 * 计算价格
	 * 
	 * @param orgnic
	 *            原价
	 * @param rate
	 *            折扣
	 * @return
	 */
	double calPrice(double orgnic, double rate);

}
