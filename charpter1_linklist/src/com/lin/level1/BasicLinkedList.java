package com.lin.level1;

/**
 * @author lin
 */
public class BasicLinkedList {

    public static void main(String[] args) {
        int[] a = {10, 30, 50, 40, 20};
        LinkedListNode head = initLinkedList(a);
        System.out.println("原链表：" + printLinkedList(head));
        // 头部添加结点
        head = BasicLinkedList.insertNode(head, new LinkedListNode(60), 1);
        System.out.println("头部添加结点：" + printLinkedList(head));
        head = initLinkedList(a);
        // 尾部添加结点
        head = BasicLinkedList.insertNode(head, new LinkedListNode(60), getListLength(head) + 1);
        System.out.println("尾部添加结点：" + printLinkedList(head));
        head = initLinkedList(a);
        // 中间添加结点
        head = BasicLinkedList.insertNode(head, new LinkedListNode(60), 3);
        System.out.println("中间添加结点：" + printLinkedList(head));
    }

    /**
     * 获取链表长度
     *
     * @param head 链表头结点
     * @return 链表长度
     */
    public static int getListLength(LinkedListNode head) {
        int length = 0;
        LinkedListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 链表插入
     *
     * @param head       链表头结点
     * @param nodeInsert 待插入结点
     * @param position   待插入位置，从1开始
     * @return 插入后得到的链表头结点
     */
    public static LinkedListNode insertNode(LinkedListNode head, LinkedListNode nodeInsert, int position) {
        // head == null 时可认为 nodeInsert 为链表头结点
        if (head == null) {
            return nodeInsert;
        }

        int size = getListLength(head);
        if (position < 1 || position > size + 1) {
            System.out.println("位置参数错误");
            return head;
        }

        // 头部添加元素
        if (position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }

        // 中间添加元素，当 position == size + 1 时，为尾部添加元素
        LinkedListNode pNode = head;
        int count = 1;
        while (count < position - 1) {
            pNode = pNode.next;
            count++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;

        return head;
    }

    /**
     * 通过数组初始化单向链表
     *
     * @param array 数据数组
     * @return 链表头结点
     */
    public static LinkedListNode initLinkedList(int[] array) {
        LinkedListNode head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            LinkedListNode newNode = new LinkedListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param head 链表的头结点
     * @return 链表元素字符串，例：10 30 50 40 20
     */
    public static String printLinkedList(LinkedListNode head) {
        LinkedListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
