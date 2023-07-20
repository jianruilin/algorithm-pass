package com.lin.level1;

/**
 * @author lin
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = initList(array);
        System.out.println(printList(head));
        head = reverseList1(head);
        System.out.println(printList(head));
        head = initList(array);
        head = reverseList2(head);
        System.out.println(printList(head));
    }

    /**
     * 建立虚拟头结点辅助反转
     *
     * @param head 链表首结点
     * @return 反转后的链表首结点
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode(-1);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = ans.next;
            ans.next = curr;
            curr = next;
        }
        return ans.next;
    }

    /**
     * 直接操作链表实现反转
     *
     * @param head 链表首结点
     * @return 反转后的链表首结点
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode initList(int[] array) {
        ListNode head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    public static String printList(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
