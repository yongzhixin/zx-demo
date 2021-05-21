package com.zx.demo.datastructure.linkedlist;

/**
 * 环形链表：解决约瑟夫问题(josephu、约瑟夫环)
 */
public class CircleLinkedListDemo {

    public static void main(String[] args) {
        CircleLinkedList clList = new CircleLinkedList();
//        clList.showCLL();
//        clList.addCNode(25);
//        clList.showCLL();
        clList.popCircleLL(41, 1, 3);
    }

}

class CircleLinkedList {
    public CNode first;

    /**
     * 添加环形链表节点
     *
     * @param num
     */
    public void addCNode(int num) {
        if (num < 1) {
            System.out.println("至少得有一个节点");
            return;
        }
        CNode curr = null;
        for (int i = 1; i <= num; i++) {
            CNode node = new CNode(i);
            if (i == 1) {
                first = node;
                first.next = first;// 自己形成一个环
                curr = first;
            } else {
                curr.next = node;
                curr = curr.next;
                curr.next = first;
            }
        }
    }

    /**
     * 出环形链表
     *
     * @param nums
     * @param start
     * @param countNum
     */
    public void popCircleLL(int nums, int start, int countNum) {
        if (nums < 2 || start < 1 || start > nums || countNum < 2) {
            System.out.println("参数错误");
            return;
        }
        addCNode(nums);
        if (first == null) {
            System.out.println("环形链表为空，不能出圈");
            return;
        }
        CNode pre = null;
        for (int i = 0; i < start - 1; i++) {// 移动到要开始计数的节点
            pre = first;
            first = first.next;
        }
        while (pre != first) {
            for (int i = 0; i < countNum - 1; i++) {// 报数
                pre = first;
                first = first.next;
            }
            System.out.printf("出约瑟夫环的编号： %d\n", first.no);
            first = first.next;
            pre.next = first;
        }
        System.err.printf("最后剩下的编号： %d\n", first.no);
    }

    /**
     * 显示环形链表中的所有数据
     */
    public void showCLL() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }
        CNode temp = first;
        while (true) {
            System.out.printf("编号 %d\n", temp.no);
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
    }

}

class CNode {

    public int no;
    public CNode next;

    public CNode(int no) {
        this.no = no;
    }
}
