package com.zx.demo.datastructure.recursion;

/**
 * 迷宫回溯
 */
public class Maze {

    public static void main(String[] args) {
        // 创建一个11*11的迷宫
        int[][] map = new int[11][11];
        for (int i = 0; i < 11; i++) {// 初始化墙体
            map[0][i] = 1;
            map[10][i] = 1;
            map[i][0] = 1;
            map[i][10] = 1;
        }
        // 设置路障
        map[5][1] = 1;
        map[5][2] = 1;
        map[6][3] = 1;
        map[6][4] = 1;
        map[5][4] = 1;
        map[4][4] = 1;
        map[3][4] = 1;
        map[2][4] = 1;
        map[2][3] = 1;
        map[2][2] = 1;

        for (int[] rows : map) {
            for (int v : rows) {
                System.out.printf("%d\t", v);
            }
            System.out.println();
        }

//        findWay(map, 1, 1);
        findWay2(map, 1, 1);

        System.out.println("行进之后的地图：");
        for (int[] rows : map) {
            for (int v : rows) {
                System.out.printf("%d\t", v);
            }
            System.out.println();
        }

    }

    /**
     * 小球找路
     * 规则：
     * 1.map表示地图
     * 2.x,y表示开始坐标
     * 3.如果小球能走到map[10][10]的位置，说明路是通的
     * 4.约定，当map[x][y]的值为 0-没走过，1-墙，2-通路可以走，3-已经走过了，但是走不通
     * 5.在走迷宫时，需要确定一个策略（即行进方向），下->右->上->左，如果点走不通，再回溯
     * 6.最短路径与行走策略有关
     *
     * @param map
     * @param x
     * @param y
     * @return
     */
    public static boolean findWay(int[][] map, int x, int y) {
        if (map[9][9] == 2) {
            return true;// 已经走到终点了
        }
        if (map[x][y] == 0) {// 可以走
            map[x][y] = 2;
            if (findWay(map, x + 1, y)) {// 向下
                return true;
            } else if (findWay(map, x, y + 1)) {// 向右
                return true;
            } else if (findWay(map, x - 1, y)) {// 向上
                return true;
            } else if (findWay(map, x, y - 1)) {// 向左
                return true;
            } else {// 都没走通
                map[x][y] = 3;
                return false;
            }
        } else {// 其他情况为1，2，3
            return false;
        }
    }

    /**
     * 修改策略 上->右->下->左
     *
     * @param map
     * @param x
     * @param y
     * @return
     */
    public static boolean findWay2(int[][] map, int x, int y) {
        if (map[9][9] == 2) {
            return true;// 已经走到终点了
        }
        if (map[x][y] == 0) {// 可以走
            map[x][y] = 2;
            if (findWay2(map, x - 1, y)) {// 向上
                return true;
            } else if (findWay2(map, x, y + 1)) {// 向右
                return true;
            } else if (findWay2(map, x + 1, y)) {// 向下
                return true;
            } else if (findWay2(map, x, y - 1)) {// 向左
                return true;
            } else {// 都没走通
                map[x][y] = 3;
                return false;
            }
        } else {// 其他情况为1，2，3
            return false;
        }
    }

}
