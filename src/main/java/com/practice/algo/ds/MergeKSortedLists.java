package com.practice.algo.ds;

import java.util.PriorityQueue;

public class MergeKSortedLists {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                heap.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (!heap.isEmpty()) {
            temp.next = new ListNode(heap.poll());
            temp = temp.next;
        }
        return node.next;
    }
}
