package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeTraversals {


    public List<Integer> bfsTraversal(Tree tree) {
        List<Integer> output = new ArrayList<>();
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree fromQueue = queue.poll();
            output.add(fromQueue.node);
            if (fromQueue.leftChild != null) {
                queue.add(fromQueue.leftChild);
            }
            if (fromQueue.rightChild != null) {
                queue.add(fromQueue.rightChild);
            }
        }
        return output;
    }

    public void inorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }
        inorderTraversal(tree.leftChild);
        System.out.println(tree.node);
        inorderTraversal(tree.rightChild);
    }

    public void preorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.node);
        preorderTraversal(tree.leftChild);
        preorderTraversal(tree.rightChild);
    }

    public void postorderTraversal(Tree tree) {
        if (tree == null) {
            return;
        }
        postorderTraversal(tree.leftChild);
        postorderTraversal(tree.rightChild);
        System.out.println(tree.node);
    }

    public List<Integer> rightViewOfTree(Tree tree) {
        List<Integer> output = new ArrayList<>();
        Queue<Tree> queue = new ArrayDeque<>();
        int maxLevel = 0;
        Map<Integer, Integer> nodeLevelMap = new HashMap<>();
        queue.add(tree);
        nodeLevelMap.put(tree.node, 1);
        while (!queue.isEmpty()) {
            Tree fromQueue = queue.poll();
            if (maxLevel < nodeLevelMap.get(fromQueue.node)) {
                output.add(fromQueue.node);
                maxLevel = nodeLevelMap.get(fromQueue.node);
            }
            if (fromQueue.rightChild != null) {
                queue.add(fromQueue.rightChild);
                nodeLevelMap.put(fromQueue.rightChild.node, nodeLevelMap.get(fromQueue.node) + 1);
            }
            if (fromQueue.leftChild != null) {
                queue.add(fromQueue.leftChild);
                nodeLevelMap.put(fromQueue.leftChild.node, nodeLevelMap.get(fromQueue.node) + 1);
            }
            nodeLevelMap.remove(fromQueue.node);
        }
        return output;
    }

    public List<Integer> leftViewOfTheTree(Tree tree) {
        List<Integer> output = new ArrayList<>();
        Queue<Tree> queue = new ArrayDeque<>();
        int maxLevel = 0;
        Map<Integer, Integer> nodeLevelMap = new HashMap<>();
        queue.add(tree);
        nodeLevelMap.put(tree.node, 1);
        while (!queue.isEmpty()) {
            Tree fromQueue = queue.poll();
            if (maxLevel < nodeLevelMap.get(fromQueue.node)) {
                output.add(fromQueue.node);
                maxLevel = nodeLevelMap.get(fromQueue.node);
            }
            if (fromQueue.leftChild != null) {
                queue.add(fromQueue.leftChild);
                nodeLevelMap.put(fromQueue.leftChild.node, nodeLevelMap.get(fromQueue.node) + 1);
            }
            if (fromQueue.rightChild != null) {
                queue.add(fromQueue.rightChild);
                nodeLevelMap.put(fromQueue.rightChild.node, nodeLevelMap.get(fromQueue.node) + 1);
            }
            nodeLevelMap.remove(fromQueue.node);
        }
        return output;
    }

    public int lowestCommonAncestor(Tree tree, int input1, int input2) {
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree fromQueue = queue.poll();
            if (fromQueue.node == input1) {
                fromQueue.found1 = true;
                Tree temp = fromQueue.parent;
                while (temp != null) {
                    temp.found1 = true;
                    if (temp.found2) {
                        return temp.node;
                    }
                    temp = temp.parent;
                }
            }
            if (fromQueue.node == input2) {
                fromQueue.found2 = true;
                Tree temp = fromQueue.parent;
                while (temp != null) {
                    temp.found2 = true;
                    if (temp.found1) {
                        return temp.node;
                    }
                    temp = temp.parent;
                }
            }
            if (fromQueue.leftChild != null) {
                fromQueue.leftChild.parent = fromQueue;
                queue.add(fromQueue.leftChild);
            }
            if (fromQueue.rightChild != null) {
                fromQueue.rightChild.parent = fromQueue;
                queue.add(fromQueue.rightChild);
            }
        }
        return -1;
    }

    public int rightMostLeafInCompleteBinaryTree(Tree tree) {
        return 0;
    }

    private static class Tree {
        int node;
        Tree leftChild;
        Tree rightChild;
        Tree parent;
        boolean found1;
        boolean found2;
    }

    public static void main(String[] s) {
        Tree tree = new Tree();
        tree.node = 1;
        Tree leftTree = new Tree();
        leftTree.node = 2;
        Tree rightTree = new Tree();
        rightTree.node = 3;

        Tree leftTree1 = new Tree();
        leftTree1.node = 4;
        Tree rightTree1 = new Tree();
        rightTree1.node = 5;

        leftTree.leftChild = leftTree1;
        leftTree.rightChild = rightTree1;

        tree.leftChild = leftTree;
        tree.rightChild = rightTree;

        System.out.println(new BinaryTreeTraversals().bfsTraversal(tree));
        System.out.println("------------------");
        new BinaryTreeTraversals().inorderTraversal(tree);
        System.out.println("------------------");
        new BinaryTreeTraversals().preorderTraversal(tree);
        System.out.println("------------------");
        new BinaryTreeTraversals().postorderTraversal(tree);
        System.out.println("------------------");
        System.out.println(new BinaryTreeTraversals().rightViewOfTree(tree));

        System.out.println("------------------");
        System.out.println(new BinaryTreeTraversals().leftViewOfTheTree(tree));

        System.out.println("------------------");
        System.out.println(new BinaryTreeTraversals().lowestCommonAncestor(tree, 5, 4));
    }
}
