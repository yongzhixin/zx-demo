package com.zx.demo.datastructure.stack;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        System.out.println(((0 + 1) & (0 + 1)) - 1 == 0);
        System.out.println(((1 + 1) & (0 + 1)) - 1 == 0);
        System.out.println(((2 + 1) & (0 + 1)) - 1 == 0);

        System.out.println(((0 + 1) & (1 + 1)) - 1 == 1);
        System.out.println(((1 + 1) & (1 + 1)) - 1 == 1);
        System.out.println(((2 + 1) & (1 + 1)) - 1 == 1);
    }

}

class LinkedListStack<T> {
    private int maxSize;
    private Node<T> head = new Node<>();
    private Node<T> top;

    public boolean isFull() {
        return maxSize == size();
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 单链表的节点个数，除头节点外（头节点不存储数据）
     *
     * @return
     */
    public int size() {
        int size = 0;
        Node temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

class Node<T> {
    T item;
    Node<T> next;

    public Node() {
    }

    public Node(T item) {
        this.item = item;
    }
}