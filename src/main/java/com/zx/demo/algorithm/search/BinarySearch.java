package com.zx.demo.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 56, 100, 2134};
        int index = binarySearch(arr, 1000);
        System.out.println("index = " + index);
    }

    /**
     * 二分查找，只能查找有序数列
     *
     * @param arr
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int findVal) {
        return binarySearch(arr, 0, arr.length - 1, findVal);
    }

    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {// 向右边递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {// 向左递归
            return binarySearch(arr, left, mid - 1, findVal);// 因为mid这个下标已经查找了
        } else {
            return mid;
        }
    }

}
