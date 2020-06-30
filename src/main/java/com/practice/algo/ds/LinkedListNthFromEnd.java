package com.practice.algo.ds;

public class LinkedListNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        node = head;
        if (count <= n) {
            head = head.next;
            return head;
        }
        while (count - n > 1) {
            node = node.next;
            count--;
        }
        node.next = node.next.next;
        return head;
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode tempNode = head;
        int temp = n;
        ListNode node = tempNode;
        while (node != null) {
            node = tempNode;
            while (temp > 0 && node != null) {
                node = node.next;
                temp--;
            }
            if (node == null) {
                tempNode.next = tempNode.next.next;
                break;
            } else {
                tempNode = tempNode.next;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] s) {
        LinkedListNthFromEnd ls = new LinkedListNthFromEnd();
        ListNode head = ls.new ListNode(1);
        head.next = ls.new ListNode(2);

        ListNode output = ls.removeNthFromEndOnePass(head, 2);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }
}
