package com.zx.demo.demode.strategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.zx.demo.demode.strategy.model.Consumer;


public class StrategyFactory {

	private StrategyFactory() {
	}

	/**
	 * 获取策略类型
	 * 
	 * @param consumer
	 * @return
	 */
	public static StrategyType createStrategy(Consumer consumer) {
		for (StrategyType type : StrategyType.values()) {
			Strategy strategy;
			try {
				strategy = handleAnnotation(type);
				if (strategy == null) {
					continue;
				}
				if (consumer.getTotal() > strategy.min() && consumer.getTotal() <= strategy.max()) {
					return type;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return StrategyType.COMMON;
			}
		}
		return StrategyType.COMMON;
	}

	private static Strategy handleAnnotation(StrategyType type) throws NoSuchFieldException, SecurityException {
		Field field = type.getClass().getField(type.name());
		Annotation[] annotations = field.getAnnotations();
		if (annotations == null) {
			return null;
		}
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			if (annotation instanceof Strategy) {
				return (Strategy) annotation;
			}
		}
		return null;
	}

}
