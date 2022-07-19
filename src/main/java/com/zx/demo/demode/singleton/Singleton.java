package com.zx.demo.demode.singleton;

/**
 * 通过静态内部类实现的单例：懒加载；通过classLoader加载机制实现单例
 *
 * @author zhixin
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton init...");
    }

    private static class SingletonHolder {
        static {
            System.out.println("SingletonHolder loading 1 ...");
        }

        private final static Singleton INSTANCE = new Singleton();

        static {
            System.out.println("SingletonHolder loading 2 ...");
        }
    }

    public static Singleton getInstance() {
//        return null;// 验证静态内部类的加载时机：第一次使用时加载
        return SingletonHolder.INSTANCE;
    }

    static {
        System.out.println("Singleton loading...");
    }
}
