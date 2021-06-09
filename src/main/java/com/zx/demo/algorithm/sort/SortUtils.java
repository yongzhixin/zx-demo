package com.zx.demo.algorithm.sort;

public class SortUtils {


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        // 时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡排序，每一轮没有交换则提前退出
     *
     * @param arr
     */
    public static void bubblesort2(int[] arr) {
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
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
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

    /**
     * 插入排序
     *
     * @param arr
     */
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
                }
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
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序-冒泡排序的升级版
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < mid) {// 如果左边的比中值小，则继续向右边找，最多找到中值处停止
                l++;
            }
            while (arr[r] > mid) {// 如果右边的比中值大，则继续向左边找，最多找到中值处停止
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[l] == mid) {// 中值被交换到了左边
                r--;
            }
            if (arr[r] == mid) {// 中值被交换到了右边
                l++;
            }
        }
        if (l == r) {// 最终查找结果是左右两边均没有符合条件的值，均找到中值处
            l++;// 这个地方不能反了，因为上面while中是++，如果这里减可能会导致把加的值再减回去，而造成无限递归，导致StackOverFlowError
            r--;// 和l意义一样
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
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
