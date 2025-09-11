package com.practice.algo.ds;

import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class MaxStack {
    public static class Node implements Comparable<Node> {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return n.value - this.value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }

    Node head;
    Node tail;
    SortedMap<Integer, Stack<Node>> keyToNodeMap;

    public MaxStack() {
        head = new Node(Integer.MAX_VALUE);
        tail = new Node(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
        keyToNodeMap = new TreeMap<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        Node n = new Node(x);
        insertAfter(head, n);
        keyToNodeMap.computeIfAbsent(x, z -> new Stack<>()).push(n);
    }

    public int pop() {
        Node topNode = head.next;
        removeNode(topNode);
        int val = topNode.value;
        keyToNodeMap.get(val).pop();
        if (keyToNodeMap.get(val).isEmpty()) {
            keyToNodeMap.remove(val);
        }
        return val;
    }

    /*
     * @return: An integer
     */
    public int top() {
        return head.next.value;
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        return keyToNodeMap.lastKey();
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        int maxValue = keyToNodeMap.lastKey();
        Node maxNode = keyToNodeMap.get(maxValue).pop();
        removeNode(maxNode);
        if (keyToNodeMap.get(maxValue).isEmpty()) {
            keyToNodeMap.remove(maxValue);
        }
        return maxValue;
    }

    private void removeNode(Node currnode) {
        currnode.prev.next = currnode.next;
        currnode.next.prev = currnode.prev;
    }

    private void insertAfter(Node currnode, Node tbinode) {
        tbinode.next = currnode.next;
        currnode.next.prev = tbinode;
        currnode.next = tbinode;
        tbinode.prev = currnode;
    }

    public static void main(String[] s) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        maxStack.push(6);
        System.out.println(maxStack.top());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
        System.out.println(maxStack.peekMax());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.top());
    }
}
