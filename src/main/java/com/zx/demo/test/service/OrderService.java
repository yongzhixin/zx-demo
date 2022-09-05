package com.zx.demo.test.service;

import com.zx.demo.spring.Component;
import com.zx.demo.spring.InitializingBean;

@Component
public class OrderService implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println("OrderService init...");
    }
}
