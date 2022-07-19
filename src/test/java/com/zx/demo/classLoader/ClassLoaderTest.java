package com.zx.demo.classLoader;

import junit.framework.TestCase;

public class ClassLoaderTest extends TestCase {


    public void test() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader + " " + extClassLoader.getClass().getSuperclass());

        ClassLoader parent = extClassLoader.getParent();
        System.out.println(parent);

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader strClassLoader = String.class.getClassLoader();
        System.out.println(strClassLoader);

    }

}
