package com.zx.demo.demode.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 策略
 * 
 * @author zhixin
 *
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Strategy {

	/**
	 * 最大值
	 * 
	 * @return
	 */
	int max() default Integer.MAX_VALUE;

	/**
	 * 最小值
	 * 
	 * @return
	 */
	int min() default 0;

}
