package com.zx.demo.algorithm.search;

public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 60);
        System.out.println("index = " + index);
    }

    /**
     * 插值查找，也是需要查询有序数列
     * 插值查找对均匀分布的数列查询很快
     *
     * @param arr
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr, int findVal) {
        return insertValueSearch(arr, 0, arr.length - 1, findVal);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查询");
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {// 向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
