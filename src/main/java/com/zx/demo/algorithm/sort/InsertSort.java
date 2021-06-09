package com.zx.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {

//        int[] arr = {101, 34, 119, 1, -1, 30};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        insertSort2(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        insertSort(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");

    }

    public static void insertSort(int[] arr) {
        int insertVal, insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {// 被插入的位置发生变化时，貌似加if更加耗时点儿，可以不加
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int insertVal = arr[i + 1];
            int insertIndex = i;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }

}
