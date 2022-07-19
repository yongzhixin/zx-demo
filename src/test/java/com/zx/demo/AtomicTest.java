package com.zx.demo;

import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends TestCase {

    public void test() {
        AtomicLong time = new AtomicLong(0);
        time.addAndGet(1);
        time.getAndAdd(1);

        AtomicInteger atInt = new AtomicInteger();
        atInt.addAndGet(1);
        atInt.getAndAdd(1);


        Object a = null;
        if (a == null) {
//            syste
        }

        String b = (String) a;
        System.out.println(b);
    }

    public void testCal() {
        long interval = 666;
        int unit = 600;
        System.out.println(interval / unit);
    }

}
