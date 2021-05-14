package com.zx.demo.datastructure.arrays;

import com.zx.demo.demode.strategy.model.Consumer;

/**
 * 稀疏数组：以五子棋为例
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个11*11的五子棋棋盘，0-无子，1-黑子，2-白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[5][4] = 2;

        System.out.println("原始棋盘数据（二维数组）：");
        for (int[] rows : chessArr) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 转换成稀疏数组：
        int sum = 0;// 计算有效值的个数
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArr = new int[sum + 1][3];// 存第一行的数据
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("转换的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        // 将稀疏数组转二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("稀疏数组转二维数组为：");
        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }


}
