package com.zx.demo.datastructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue<Integer> queue = new CircleArrayQueue<>(3);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char type = '  ';
        while (loop) {
            System.out.println("l:显示队列中的数据");
            System.out.println("a:添加数据");
            System.out.println("g:出队数据");
            System.out.println("p:读取队头数据");
            System.out.println("e:退出");
            System.out.println("---------------------------");
            type = scanner.next().charAt(0);
            switch (type) {
                case 'l':
                    try {
                        queue.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入数值：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int v = queue.getQueue();
                        System.out.println("取出的队列数据为：" + v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int head = queue.peekHead();
                        System.out.println("读取的队列头为：" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
            System.out.println("================================");
        }
        System.out.println("程序退出");
    }

}

/**
 * 用数组模拟一个环形数组队列
 */
class CircleArrayQueue<T> {
    private int maxSize;// 最大size
    private int front;// 队列头
    private int reer;// 队列尾
    private Object[] arr;// 数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;// 预留一个空间出来
        arr = new Object[this.maxSize];
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (reer + 1) % maxSize == front;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == reer;
    }

    /**
     * 向队列中添加元素
     *
     * @param value
     */
    public void addQueue(T value) {
        if (isFull()) {
            System.out.println("队列已满，无法入队");
            return;
        }
        arr[reer] = value;
        reer = (reer + 1) % maxSize;// reer++;
    }

    /**
     * 取出队列中的元素
     *
     * @return
     */
    public T getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        Object value = arr[front];
        front = (front + 1) % maxSize;// front++
        return (T) value;
    }

    /**
     * 查看队列头部元素
     *
     * @return
     */
    public T peekHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return (T) arr[front];
    }

    /**
     * 打印队列所有元素
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, (T) arr[i % maxSize]);
        }
    }

    /**
     * 队列元素个数
     *
     * @return
     */
    public int size() {
        return (reer + maxSize - front) % maxSize;
    }
}
