package com.practice.algo.ds;

/**
 * 1 -> 2 -> 3 -> 4 -> 5
 * p = null
 * c = 1
 * n = 2
 *
 * p = 1
 * c = 2
 * n = 3
 *
 */
public class ReverseLinkedList {
    
    public static void main(String[] s) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        
        new ReverseLinkedList().reverseBetween(listNode, 1, 2);
    
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            if (prev != null) {
                ListNode temp = curr;
                temp.next = prev;
                prev.next = null;
            }
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pPrev = null;
        ListNode rNext = null;
        ListNode curr = head;
        ListNode l = null;
        ListNode r = null;
        int pos = 1;
        while(curr != null) {
            if(pos == left) {
                l = curr;
            }
            if(pos == right) {
                r = curr;
                rNext = curr.next;
                break;
            }
            if(l == null) {
                pPrev = curr;
            }
            curr = curr.next;
            pos++;
        }
        if(l == null || r == null || l == r) {
            return head;
        }
    
        ListNode prev = l;
        ListNode cur = l.next;
        prev.next = rNext;
    
        while(cur != r) {
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        cur.next = prev;
        prev = cur;
    
        if(pPrev != null) {
            pPrev.next = prev;
        } else {
            head = prev;
        }
        return head;
    }
}
