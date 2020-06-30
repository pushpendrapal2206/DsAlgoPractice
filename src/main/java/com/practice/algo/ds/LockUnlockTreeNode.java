package com.practice.algo.ds;

public class LockUnlockTreeNode {

    public boolean lock(Tree node) {
        if (node.isLocked) {
            return false;
        }
        node.isLocked = true;
        Tree tempNode = node;
        while (tempNode.parent != null) {
            if (tempNode.parent.isLocked) {
                break;
            }
            tempNode.parent.isLocked = true;
            tempNode = tempNode.parent;
        }
        return true;
    }

    public boolean unlock(Tree node) {
        if (node.isLocked) {
            node.isLocked = false;
            return true;
        }
        throw new RuntimeException("Already unocked!");
    }

    private static class Tree {
        int node;
        boolean isLocked;
        Tree parent;

        Tree(int node) {
            this.node = node;
        }
    }

    public static void main(String[] s) {
        LockUnlockTreeNode lockUnlockTreeNode = new LockUnlockTreeNode();
        Tree parentNode = new Tree(1);
        Tree childNode = new Tree(2);
        childNode.parent = parentNode;
        Tree childNode2 = new Tree(3);
        childNode2.parent = parentNode;
        new Tree(4).parent = childNode;
        new Tree(5).parent = childNode;
        new Tree(6).parent = childNode2;
        new Tree(7).parent = childNode2;
        System.out.println(lockUnlockTreeNode.lock(childNode2));
        System.out.println(lockUnlockTreeNode.unlock(childNode));
    }
}
