package com.zx.demo.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList<Hero> list = new SingleLinkedList<Hero>();
//        for (int i = 1; i <= 10; i++) {
//            Hero hero = new Hero(i, "工具人" + i);
//            list.add(hero);
//        }
        Hero hero = new Hero(1, "工具人1");
        Hero hero2 = new Hero(2, "工具人2");
        Hero hero3 = new Hero(3, "工具人3");
        Hero hero4 = new Hero(4, "工具人4");
        list.addByOrder(hero);
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.addByOrder(hero3);

        System.out.println("size: " + list.size());

        list.list();

        System.out.printf("反向查找第%d个节点结果：%s\n", 0, list.getRevertNode(0));
        System.out.printf("反向查找第%d个节点结果：%s\n", 5, list.getRevertNode(5));
        System.out.printf("反向查找第%d个节点结果：%s\n", 2, list.getRevertNode(2));

        System.out.println("反向遍历单链表的数据：");
        list.revertPrint();

        System.out.println("反转单链表后的数据：");
        list.revert();
        list.list();

        list.del(1);
        list.del(4);
        list.del(3);
        list.del(2);

        System.out.println("删除后的链表数据：");

        list.list();
    }

}


class SingleLinkedList<T extends Order> {
    private Node<T> head = new Node<T>();

    /**
     * 顺序添加的队尾
     *
     * @param t
     */
    public void add(T t) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = new Node(t);
    }

    /**
     * 按编号顺序添加
     *
     * @param t
     */
    public void addByOrder(T t) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {// 已经是最后一个了
                break;
            }
            if (temp.next.t.order() > t.order()) {
                break;
            } else if (temp.next.t.order() == t.order()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.err.printf("编号%d已存在，不能添加\n", t.order());
        } else {
            Node node = new Node(t);
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 删除编号对应的节点
     *
     * @param no
     */
    public void del(int no) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {// 已到链表尾部
                break;
            }
            if (temp.next.t.order() == no) {// 找到需要删除的节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到要删除的数据，no: %d", no);
        }
    }

    public void list() {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
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

    /**
     * 获取反向的第index个节点数据
     *
     * @param index
     * @return
     */
    public T getRevertNode(int index) {
        int size = this.size();
        if (size == 0 || index <= 0 || size < index) {
            return null;
        }
        int preIndex = size - index;
        Node<T> temp = head.next;
        while (preIndex > 0) {
            temp = temp.next;
            preIndex--;
        }
        return temp.t;
    }

    /**
     * 反转单链表
     */
    public void revert() {
        if (head.next == null || head.next.next == null) {
            System.out.println("空链表或只有一个链表，不用反转");
        }
        Node<T> reverseHead = new Node<T>();
        Node<T> curr = head.next;
        Node<T> next = null;
        while (curr != null) {
            next = curr.next;// 保存下一个节点
            curr.next = reverseHead.next;// 需要把反转头节点的下一个节点给当前的这个节点
            reverseHead.next = curr;// 把当前节点放在反转头节点后面
            curr = next;// 移动节点
        }
        head.next = reverseHead.next;
        reverseHead.next = null;
    }

    /**
     * 反向遍历单链表，不改变链表结构，因此不使用反转方式</p>
     * 通过stack实现
     */
    public void revertPrint() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        Node<T> curr = head;
        Stack<T> stack = new Stack<T>();
        while (curr != null) {
            stack.push(curr.t);
            curr = curr.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

class Node<T extends Order> {
    public T t;
    public Node<T> next;

    public Node() {
    }

    public Node(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t +
                '}';
    }
}

abstract class Order {
    abstract int order();
}

class Hero extends Order {

    public int no;
    public String name;

    public Hero(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int order() {
        return this.no;
    }
}
