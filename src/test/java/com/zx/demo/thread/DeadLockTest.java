package com.zx.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DeadLockTest {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t2 = new Thread(() -> {
            System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            synchronized (o1) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {

                }
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }, "t2");

        Thread t1 = new Thread(() -> {
            synchronized (o2) {
                try {
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                    TimeUnit.MILLISECONDS.sleep(300);
                    TimeUnit.SECONDS.sleep(3);
                    synchronized (o1) {

                    }
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.start();

    }

}
