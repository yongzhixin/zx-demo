package com.zx.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        mergeSort(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        mergeSort(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("排序有问题");
            }
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] tempArr = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tempArr);
    }

    /**
     * 递归拆分并合并数据
     *
     * @param arr
     * @param left
     * @param right
     * @param tempArr
     */
    private static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tempArr);// 递归拆分左边
        mergeSort(arr, mid + 1, right, tempArr);// 递归拆分右边
        merge(arr, left, mid, right, tempArr);// 合并拆分的数据，合并一定是从递归方法栈顶开始合并返回上一级递归
    }

    /**
     * 合并数据
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param tempArr
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArr[t++] = arr[i++];
            } else {
                tempArr[t++] = arr[j++];
            }
        }
        while (i <= mid) {// 左边还有剩余数据未填充到tempArr
            tempArr[t++] = arr[i++];
        }
        while (j <= right) {// 右边还有剩余数据未填充到tempArr
            tempArr[t++] = arr[j++];
        }
        System.arraycopy(tempArr, 0, arr, left, t);
    }

}
