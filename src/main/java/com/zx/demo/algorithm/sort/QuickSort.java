package com.zx.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序，
 * 冒泡排序的升级版
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, -23, -567, 0};
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0};
//        quickSort(arr);
//        System.out.println("排序结果：" + Arrays.toString(arr));
//        int count = 0;
//        do {
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        quickSort(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000 + "ms");

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("排序有问题");
            }
        }
//        } while (++count < 1000);

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
//            System.out.println("++++++++++++++++++");
            while (arr[l] < mid) {// 如果左边的比中值小，则继续向右边找，最多找到中值处停止
                l++;
            }
            while (arr[r] > mid) {// 如果右边的比中值大，则继续向左边找，最多找到中值处停止
                r--;
            }
            if (l >= r) {
                break;
            }
//            System.out.println(mid + " " + l + "=" + arr[l] + " " + r + "=" + arr[r]);
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
//            System.out.println("++++ " + mid + " " + l + "=" + arr[l]);
            if (arr[l] == mid) {// 中值被交换到了左边
                r--;
            }
//            System.out.println("++++ " + mid + " " + r + "=" + arr[r]);
            if (arr[r] == mid) {// 中值被交换到了右边
                l++;
            }
//            System.out.println("==== " + Arrays.toString(arr));
//            System.out.println("==== " + l + " " + r);
        }
//        System.out.println(l + " " + r);
//        System.err.println(l + "=" + arr[l] + " " + r + "=" + arr[r]);
        if (l == r) {// 最终查找结果是左右两边均没有符合条件的值，均找到中值处
            l++;// 这个地方不能反了，因为上面while中是++，如果这里减可能会导致把加的值再减回去，而造成无限递归，导致StackOverFlowError
            r--;// 和l意义一样
        }
//        System.out.println(l + " " + r);
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

}
