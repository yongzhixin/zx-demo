package com.zx.demo.demode.strategy;

import com.zx.demo.demode.strategy.model.Consumer;

import junit.framework.TestCase;

public class StrategyMain extends TestCase {
	
	public void testStrategy(){
		Consumer consumer = new Consumer();
		consumer.buy(5000);
		consumer.buy(10000);
		consumer.buy(10000);
		consumer.buy(10000);
		consumer.buy(10000);
		consumer.buy(10000);
	}
	
	public void testString (){
		String[] strs = {"abdc1", "abcfdsdsf","abcvcbxvb","abcbvxcbxcv"};
		for(String str : strs){
			System.out.println(str.startsWith("abc"));
		}
	}

}
