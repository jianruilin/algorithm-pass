package com.lin.level1;

/**
 * @author lin
 * 单向链表结点
 */
public class LinkedListNode {
    /**
     * 数据部分
     */
    public int val;
    /**
     * 后继元素的 next 指针
     */
    public LinkedListNode next;

    /**
     * 构造方法，初始化单向链表结点对象时，用来给单向链表结点对象的数据部分赋值
     *
     * @param val 数据值
     */
    public LinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
}