package com.zx.demo;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

public class StackNewObjectTest {

    public static void main(String[] args) {
        while (true){
            try {
                newObj();
                TimeUnit.MILLISECONDS.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void newObj(){
        StackNewObjectTest t = new StackNewObjectTest();
    }

}
