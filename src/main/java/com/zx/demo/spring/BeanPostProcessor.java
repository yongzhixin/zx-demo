package com.zx.demo.spring;

/**
 * bean初始化前后执行，事务的ASpectJ就是基于这个实现的
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) {

        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
