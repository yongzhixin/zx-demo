package com.zx.demo.test;

import com.zx.demo.spring.ZxApplicationContext;
import com.zx.demo.test.service.UserService;

public class SpringDemoTest {

    public static void main(String[] args) {

        ZxApplicationContext context = new ZxApplicationContext(AppConfig.class);

        UserService userService = (UserService) context.getBean("userService");
//        UserService userService2 = (UserService) context.getBean("userService");
//        UserService userService3 = (UserService) context.getBean("userService");

        System.out.println(userService);
//        System.out.println(userService2);
//        System.out.println(userService3);

        userService.test();


    }

}
