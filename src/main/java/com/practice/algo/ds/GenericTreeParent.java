package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *          1
 *       2
 *     3        4
 *  5 6 7 |  8 9 10 11
 * <p>
 * 4 5
 */

public class GenericTreeParent {

    public int findParent(Node rootNode, int processNumber) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(rootNode);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            for (Node child : node.children) {
                if (child.val == processNumber) {
                    return node.val;
                }
                nodeQueue.add(child);
            }
        }
        return -1;
    }

    public static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        rootNode.addChild(node1);
        node1.addChild(node2);
        node1.addChild(node3);
        node2.addChild(node4);
        node2.addChild(node5);
        node2.addChild(node6);

        System.out.println(new GenericTreeParent().findParent(rootNode, 12));
    }
}
