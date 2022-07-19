package com.zx.demo.algorithm.search;

public class FibonacciSearch {

    public static final int maxSize = 20;

    public static void main(String[] args) {

    }

    public static int fibSearch(int[] arr, int findVal) {
        return fibSearch(arr, 0, arr.length - 1, findVal);
    }

    private static int fibSearch(int[] arr, int low, int high, int findVal) {
//        int low = 0;
//        int high = a
        return -1;
    }

    /**
     * 生成一个斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

}
