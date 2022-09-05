package com.zx.demo.test.service;

import com.zx.demo.spring.Autowired;
import com.zx.demo.spring.Component;
import com.zx.demo.spring.Scope;

@Component("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test() {
        System.out.println("OrderService: " + orderService);
    }

}
