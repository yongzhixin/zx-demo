package com.zx.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.println("排序前：" + Arrays.toString(arr));
////        shellSort(arr);
//        shellSort2(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));

        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = (int) (Math.random() * 800000000);
        }
        long start = System.nanoTime();
//        shellSort(arr);
        shellSort2(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");

//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            arr.add((int) (Math.random() * 800000000));
//        }
//        long start = System.nanoTime();
//        Collections.sort(arr);
//        long end = System.nanoTime();
//        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");
    }

    /**
     * 希尔排序-交换式
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
//                    System.out.printf("gap=%d, i=%d, j=%d\n", gap, i, j);
//                    System.out.println(Arrays.toString(arr));
                }
//                System.out.println("-----------------");
            }
        }

    }

    /**
     * 希尔排序-移位式
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
//                System.out.println("---------------");
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
//                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

}
