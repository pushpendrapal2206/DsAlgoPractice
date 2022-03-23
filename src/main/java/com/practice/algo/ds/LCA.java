package com.practice.algo.ds;

public class LCA {
    
    public static void main(String[] s) {
        LCA lca = new LCA();
        TreeNode root = lca.new TreeNode(6);
        root.left = lca.new TreeNode(2);
        root.left.left = lca.new TreeNode(0);
        root.left.right =  lca.new TreeNode(4);
        root.left.right.left =  lca.new TreeNode(3);
        root.left.right.right =  lca.new TreeNode(5);
        
        
        
        
        root.right =  lca.new TreeNode(8);
        root.right.left =  lca.new TreeNode(7);
        root.right.right =  lca.new TreeNode(9);
    
        TreeNode treeNode = lca.lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
        
        System.out.println(treeNode);
        
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
        
        public int getValue() {
            return val;
        }
        
        public TreeNode getLeftChild() {
            return left;
        }
        
        public TreeNode getRightChild() {
            return right;
        }
    
        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.getValue() == p.getValue()) {
            return p;
        }
        if (root.getValue() == q.getValue()) {
            return q;
        }
        if (p.getValue() < root.getValue() && q.getValue() > root.getValue()) {
            return root;
        }
        
        if (p.getValue() < root.getValue() && q.getValue() < root.getValue()) {
            return lowestCommonAncestor(root.getLeftChild(), p, q);
        }
        return lowestCommonAncestor(root.getRightChild(), p, q);
    }
}
