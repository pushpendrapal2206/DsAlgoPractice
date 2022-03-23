package com.practice.algo.ds;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * <p>
 * Tags: Linked List
 * Similar Problems: (M) Add Two Numbers
 */

public class AddTwoNum2 {
    
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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode result = null;
        int remainder = 0;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (stack1.isEmpty()) {
                sum = stack2.pop();
            } else if (stack2.isEmpty()) {
                sum = stack1.pop();
            } else {
                sum = stack1.pop() + stack2.pop();
            }
            if (result == null) {
                sum = (sum % 10) + remainder;
                result = new ListNode(sum % 10);
            } else {
                sum = (sum % 10) + remainder;
                ListNode temp = new ListNode(sum % 10);
                temp.next = result;
                result = temp;
            }
            remainder = sum / 10;
        }
        return result;
    }
    
    public static void main(String[] s) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(5);
        
        // [1 -> 0 -> 0 -> 7 -> 8]
        
        ListNode result = new AddTwoNum2().addTwoNumbers(listNode, listNode2);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
