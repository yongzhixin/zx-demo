package com.zx.demo.thread;

import java.util.concurrent.TimeUnit;

public class SyncTest {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(() -> {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "t" + i);
            thread.start();
            TimeUnit.MILLISECONDS.sleep(100);
        }

    }

}
