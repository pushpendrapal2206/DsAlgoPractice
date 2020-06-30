package com.practice.algo.ds;

import java.util.ArrayList;

/*
   Post order traversal of BST is: 10, 21, 25, 20, 43, 50, 45, 30
   Construct the binary search tree from the traversal.
*/

public class PostOrderToInorderTree {
    private static Tree tree = new Tree(null);
    private static int from;

    public static void main(String[] args) {
        ArrayList<Integer> strings = new ArrayList<Integer>();
        strings.add(10);
        strings.add(21);
        strings.add(25);
        strings.add(20);
        strings.add(43);
        strings.add(50);
        strings.add(45);
        strings.add(30);
        from = strings.size() - 1;
        buildTree(tree, strings);
        printInorder(tree);
    }

    private static void buildTree(Tree tree, ArrayList<Integer> strings) {
        while (PostOrderToInorderTree.from > 0) {
            tree.setNode(strings.get(from));
            if (strings.get(from) < strings.get(from - 1)) {
                from--;
                tree.setRight(new Tree(tree));
                buildTree(tree.getRight(), strings);
            } else {
                while (tree.getParent() != null && tree.getParent().getNode() > strings.get(from - 1)) {
                    tree = tree.getParent();
                }
                from--;
                while (tree.getLeft() != null) {
                    tree = tree.getLeft();
                }
                tree.setLeft(new Tree(tree));
                tree.getLeft().setNode(strings.get(from));
                buildTree(tree.getLeft(), strings);
            }
        }
    }


    public static void printInorder(Tree tree) {
        if (tree == null)
            return;
        printInorder(tree.getLeft());
        System.out.println(tree.getNode());
        printInorder(tree.getRight());
    }

    private static class Tree {
        int node;
        private Tree left;
        private Tree right;
        private Tree parent;

        public Tree(Tree parent) {
            this.parent = parent;
        }

        public int getNode() {
            return node;
        }

        public Tree getLeft() {
            return left;
        }

        public Tree getRight() {
            return right;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public void setRight(Tree right) {
            this.right = right;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public Tree getParent() {
            return parent;
        }

        public void setParent(Tree parent) {
            this.parent = parent;
        }
    }


}
