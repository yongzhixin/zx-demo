package com.zx.demo;

public class ForBreakTest {

    public static int[] states = new int[]{2, 0, 0, 2, 0, 2, 0, 2, 0, 0, 2, 2, 0, 0, 0, 2};
    public static final int SIZE = 4;

    public static void main(String[] args) {
        int lines = 0;
        start:for (int i = 0; i < SIZE; i++) {
            System.out.println(i);
            for (int j = i; j < SIZE * SIZE; j = j + SIZE) {
//                System.err.println(j);
                if (!checkTask(j)) {
//                    break start;
                    continue start;
                }
//                System.err.println(j);
            }
            lines++;
        }
        System.out.println(lines);
    }

    public static boolean checkTask(int index) {
        return states[index] == 2;
    }

}
