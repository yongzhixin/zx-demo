package com.zx.demo.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 冒泡排序
 * 可以优化：如果某次没有发生未知交换，则可以提前结束循环
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 9, -1, 10, -2};
//        int[] arr = new int[]{3, 9, -1, 10, 20};// 验证优化的冒泡排序
//        sort(arr);
//        sort2(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.nanoTime();
        sort(arr);
//        sort2(arr);
        long end = System.nanoTime();
        System.out.println("排序耗时： " + (end - start) / 1000000000);
    }

    public static void sort(int[] arr) {
        int temp = 0;
        // 时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
//                System.out.println("第" + (i + 1) + "轮, 第" + (j + 1) + "步排序结果：" + Arrays.toString(arr));
            }
//            System.out.println("第" + (i + 1) + "轮排序结果：" + Arrays.toString(arr));
        }
    }

    /**
     * 优化冒泡排序，每一轮没有交换则提前退出
     *
     * @param arr
     */
    public static void sort2(int[] arr) {
        int temp = 0;
        // 时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;// 用于优化冒泡排序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
//                System.out.println("第" + (i + 1) + "轮, 第" + (j + 1) + "步排序结果：" + Arrays.toString(arr));
            }
//            System.out.println("第" + (i + 1) + "轮排序结果：" + Arrays.toString(arr));
            if (!flag) {
                break;
            }
        }
    }

}
