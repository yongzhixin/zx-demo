package com.zx.demo.datastructure.recursion;

/**
 * 8皇后问题
 */
public class Queen8 {

    int max = 8;
    /**
     * 八皇后问题的解法：理论上应该用二维数组表示，但是这是使用一维数组来表示，数组下标表示第i+1行，
     * 值array[i] = value, 值value+1表示第几列
     */
    int[] array = new int[max];

    // 解法
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.err.printf("八皇后的总解法有 %d 种", count);
    }

    /**
     * 放第几个皇后
     *
     * @param n
     */
    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {// 可以放则去放下一行
                System.err.printf("第 %d 个皇后放在 %d 列\n", n + 1, i + 1);
                check(n + 1);
            }
        }
    }

    /**
     * 第几个皇后
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 表示第i+1行放的列 == 第n+1行放的列
            // Math.abs(n - i) 表示相差多少行， Math.abs(array[n] - array[i])表示相差多少列，相等即表示在同一斜线上
            // 同一行不需要验证，因为放完当前行就会放下一行
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {// 判断是否冲突，规则：不能在同一行，同一列，同一斜线上
                return false;
            }
        }
        return true;
    }

    /**
     * 打印结果
     */
    public void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

}
