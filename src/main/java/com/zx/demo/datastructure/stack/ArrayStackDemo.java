package com.zx.demo.datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(5);
        String type;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 显示栈中的数据");
            System.out.println("push: 向栈中添加数据");
            System.out.println("pop: 从栈顶取出数据");
            System.out.println("exit: 退出");
            System.out.println("===========================\n");
            type = scanner.nextLine();
            switch (type) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    String value = scanner.nextLine();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        String v = stack.pop();
                        System.out.printf("出栈的数据为: %s\n", v);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
            System.out.println("----------------------------\n");
        }
        System.out.println("程序退出");
    }

}

/**
 * 使用数组实现栈
 *
 * @param <T>
 */
class ArrayStack<T> {
    private int maxSize;// 最大size
    private Object[] data;// 栈内的数据
    private int top = -1;// 栈顶，初始值为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }

    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否是空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 将数据压入栈顶
     *
     * @param t
     */
    public void push(T t) {
        if (isFull()) {
            System.out.println("栈满，无法将数据压入栈中");
            return;
        }
        data[++top] = t;
    }

    /**
     * 将数据从栈顶取出
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空， 不能出栈");
        }
        return (T) data[top--];// 先取出后，在移动栈顶
    }

    /**
     * 遍历栈中的元素
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("data[%d] = %s\n", i, data[i]);
        }
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public T peek() {
        return (T) data[top];
    }

}
