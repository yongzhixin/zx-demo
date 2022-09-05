package com.zx.demo.test.service;

import com.zx.demo.spring.BeanPostProcessor;
import com.zx.demo.spring.Component;

@Component
public class ZxBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("====BeanPostProcessor==== " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
