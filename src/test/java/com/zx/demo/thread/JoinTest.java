package com.zx.demo.thread;

import com.sun.javafx.font.t2k.T2KFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

//                o1.notifyAll();
//                try {
//                    TimeUnit.SECONDS.sleep(15);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                long count = 0;
                for (long i = 0; i < 30000000000L; i++) {
                    count += i;
                }
                System.out.println(count);
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }, "t2");
        t2.setPriority(10);

        Thread t3 = new Thread(() -> {
            synchronized (o2) {
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

//                o1.notifyAll();
//                try {
//                    TimeUnit.SECONDS.sleep(15);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                long count = 0;
                for (long i = 0; i < 30000000000L; i++) {
                    count += i;
                }
                System.out.println(count);
                System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }, "t3");
        t3.setPriority(10);

        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println(new Date(System.currentTimeMillis()) + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                    TimeUnit.MILLISECONDS.sleep(300);
//                    o1.wait();
                    t2.join();

                    t3.join();
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
        TimeUnit.MILLISECONDS.sleep(100);
        t3.start();

//        Thread t3 = new Thread(() -> {
//
//            ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
//            ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false, false);
//            for (ThreadInfo threadInfo : threadInfos) {
////                System.out.println("id: " + threadInfo.getThreadId() + ", name: " + threadInfo.getThreadName());
//                System.out.println(threadInfo);
//            }
//
//        }, "t3");
//
//        t3.start();

    }

}
