package com.zx.demo;

import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class StringTest {

    String s1 = new String("good");

    public static void main(String[] args) {
        StringTest test = new StringTest();
        test.change(test.s1);
//        System.out.println(test.s1);
//        test.s1 = "test haha";
//        System.out.println(" " + test.s1);
        TestObj obj = new TestObj();
        long address = VM.current().addressOf(obj);
        System.out.println(address+" "+obj);
        getUnsafe().freeMemory(address);
        obj = null;
        System.out.println(obj+" ");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void change(String s) {
//        System.out.println("___ " + s);
        s = "test";
//        System.out.println("s:  " + s);
//        System.out.println("s1:  " + s1);
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    static class TestObj{

    }

}
