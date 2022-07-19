package com.zx.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class YieldTest {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();

        Thread t2 = new Thread(() -> {
            System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            synchronized (o1) {
//                o1.notifyAll();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }, "t2");
        t2.setPriority(10);

        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                    TimeUnit.MILLISECONDS.sleep(300);
//                    o1.wait();
//                    t2.join();
                    Thread.yield();
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.setPriority(1);
        t1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.start();

    }
}
