package com.lin.level2;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author lin
 * 解答题目：<a href="https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/description/">剑指 Offer 52. 两个链表的第一个公共节点</a>
 */
class SolutionIntersectionNode {

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(0);
        ListNode nodeB3 = new ListNode(1);
        ListNode nodeC1 = new ListNode(8);
        ListNode nodeC2 = new ListNode(4);
        ListNode nodeC3 = new ListNode(5);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeC1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeC1;
        nodeC1.next = nodeC2;
        nodeC2.next = nodeC3;

        ListNode headA = nodeA1;
        ListNode headB = nodeB1;

        System.out.println(getIntersectionNode1(headA, headB).val);
        System.out.println(getIntersectionNode2(headA, headB).val);
        System.out.println(getIntersectionNode3(headA, headB).val);
        System.out.println(getIntersectionNode4(headA, headB).val);
        System.out.println(getIntersectionNode5(headA, headB).val);
    }

    /**
     * 暴力枚举
     *
     * @param headA 链表 A 的首节点
     * @param headB 链表 B 的首节点
     * @return 两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
            }
        }

        return null;
    }

    /**
     * 使用集合
     *
     * @param headA 链表 A 的首节点
     * @param headB 链表 B 的首节点
     * @return 两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        HashSet<ListNode> nodeHashSetA = new HashSet<>();
        ListNode nodeA = headA;
        while (nodeA != null) {
            nodeHashSetA.add(nodeA);
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;
        while (nodeB != null) {
            if (nodeHashSetA.contains(nodeB)) {
                return nodeB;
            }
            nodeB = nodeB.next;
        }

        return null;
    }

    /**
     * 使用栈
     *
     * @param headA 链表 A 的首节点
     * @param headB 链表 B 的首节点
     * @return 两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode nodeA = headA;
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        ListNode intersectionNode = null;
        while (stackA.size() > 0 && stackB.size() > 0) {
            if (stackA.peek() == stackB.peek()) {
                intersectionNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }

        return intersectionNode;
    }

    /**
     * 双指针
     *
     * @param headA 链表 A 的首节点
     * @param headB 链表 B 的首节点
     * @return 两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                }
                if (p2 == null) {
                    p2 = headA;
                }
            }
        }

        return p1;
    }

    /**
     * 差和双指针
     *
     * @param headA 链表 A 的首节点
     * @param headB 链表 B 的首节点
     * @return 两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode5(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 计算链表 A 的长度
        ListNode nodeA = headA;
        int lengthA = 0;
        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }

        // 计算链表 B 的长度
        ListNode nodeB = headB;
        int lengthB = 0;
        while (nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }

        // 计算链表 A 和链表 B 的长度差
        int sub = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;

        ListNode p1 = headA;
        ListNode p2 = headB;

        // 长的先走 sub 步
        if (lengthA > lengthB) {
            int count = 0;
            while (count < sub) {
                p1 = p1.next;
                count++;
            }
        }
        if (lengthB > lengthA) {
            int count = 0;
            while (count < sub) {
                p2 = p2.next;
                count++;
            }
        }

        // 同时遍历两个链表
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

}