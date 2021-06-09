package com.zx.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序的扩展）
 */
public class RadixSort {

    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214, -748};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));

        // 所需空间 800000 * 11 * 4（一个int占4个byte）
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        radixSort(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("排序有问题");
            }
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];// 找到最小值，可能有负数
            }
        }
        if (min < 0) {// 数组中有负数
            for (int i = 0; i < arr.length; i++) {// 减去一个最小的负数，将所有数变成正数
                arr[i] -= min;
            }
            max -= min;
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];// 极限情况是某一位上的数均为同一数，以空间换时间
        int[] bucketElementCount = new int[10];// 记录每个桶中的元素个数
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
//                System.out.println(arr[i] + " " + n + "  " + digitOfElement + " " + bucketElementCount[digitOfElement]);
                bucket[digitOfElement][bucketElementCount[digitOfElement]++] = arr[i];
            }
            int index = 0;
            for (int b = 0; b < bucket.length; b++) {
                if (bucketElementCount[b] != 0) {// 表示桶中有数据
                    for (int k = 0; k < bucketElementCount[b]; k++) {
                        arr[index++] = bucket[b][k];
                    }
                    bucketElementCount[b] = 0;// 把桶中个数清0
                }
            }
        }
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {// 加上一个最小的负数，将所有数恢复正常
                arr[i] += min;
            }
        }
    }

}
