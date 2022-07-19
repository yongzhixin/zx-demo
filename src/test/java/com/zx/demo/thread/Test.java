package com.zx.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {

                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                    o1.wait();
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (o1) {
                o1.notifyAll();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }, "t2");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.start();
    }

}
