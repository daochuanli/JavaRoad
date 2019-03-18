package com.soapsnake.algorithms.leetcode.list;

/**
 * @Auther soapsnake@gmail.com
 * @Date 2019-02-24 00:19
 */
public class Question24 {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 2 -> 1 -> 4 -> 3 -> 5
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode cur = fakehead;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;  //cur指针指向的是second,也就是需要交换的一对node的前一个节点
        }

        return fakehead.next;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        System.out.println("删除前head = " + head);
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode cur = head;
        ListNode pre = fakehead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return fakehead.next;
    }

    public static void main(String[] args) {
        Question24 question24 = new Question24();
        ListNode head = ListNode.makeTestListFor725();  //1 -> 2 -> 3 -> 4 -> 5
        System.out.println(question24.swapPairs(head)); //2 -> 1 -> 4 -> 3 -> 5

        System.out.println("head = " + head);
        System.out.println(question24.deleteNode(head, 5));
        System.out.println(question24.deleteNode(head, 4));
    }
}