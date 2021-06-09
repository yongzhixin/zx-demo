package com.zx.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{101, 34, 119, 1, -1, 90, 123};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        selectSort(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];// 默认第一个是最小
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}
