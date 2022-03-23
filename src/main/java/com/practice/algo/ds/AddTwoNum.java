package com.practice.algo.ds;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Company Tags: Amazon, Microsoft, Bloomberg, Airbnb, Adobe
 * Tags: Linked List, Math
 * Similar Problems: (M) Multiply Strings, (E) Add Binary, (E) Sum of Two Integers, (E) Add Strings, (M) Add Two Numbers
 * II
 */

public class AddTwoNum {
    
    public static class ListNode {
        
        public int val;
        public ListNode next;
        
        public ListNode(int x) {
            val = x;
        }
        
        public ListNode() {
        
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pointer = result;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l2.val;
                l2 = l2.next;
            }
            pointer.val = (sum % 10) + remainder;
            pointer.next = new ListNode();
            
            remainder = sum / 10;
            pointer = pointer.next;
        }
        return result;
    }
    
    public static void main(String[] s) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(5);
        
        ListNode result = new AddTwoNum().addTwoNumbers(listNode, listNode2);
        
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
