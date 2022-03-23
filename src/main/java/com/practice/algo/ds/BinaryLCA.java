package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryLCA {
    
    public static void main(String[] s) {
        BinaryLCA lca = new BinaryLCA();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        
        
        
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
    
//        TreeNode treeNode = lca.lowestCommonAncestor(root, root.left, root.left.right.right);
        
        
        System.out.println(lca.serialize(root));
        
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
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
    
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        String output = "";
        Map<TreeNode, Boolean> visited = new HashMap<>();
        
        while(queue.size() > 0) {
            TreeNode polled = queue.poll();
            output = output + polled.val + ",";
            if(polled.left != null) {
                queue.add(polled.left);
            } else {
            
            }
            if(polled.right != null) {
                queue.add(polled.right);
            }
        }
        return output;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> countMap = new HashMap<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        stack.push(root);
        int previousCount = 0;
        while(stack.size() > 0) {
            int count = 0;
            TreeNode node = stack.peek();
            if(previousCount > 0) {
                countMap.put(node, countMap.getOrDefault(node, 0) + previousCount);
                if(countMap.get(node) == 2) {
                    return node;
                }
            }
            if(node.left != null && !visited.getOrDefault(node.left, false)) {
                stack.push(node.left);
                previousCount = 0;
            } else if(node.right != null && !visited.getOrDefault(node.right, false)) {
                stack.push(node.right);
                previousCount = 0;
            } else {
                TreeNode popped = stack.pop();
                visited.put(popped, true);
                if(popped.val == p.val) {
                    count++;
                    previousCount = count;
                    countMap.put(popped, countMap.getOrDefault(popped, 0) + previousCount);
                    if(countMap.get(popped) == 2) {
                        return popped;
                    }
                } else if(popped.val == q.val) {
                    count++;
                    previousCount = count;
                    countMap.put(popped, countMap.getOrDefault(popped, 0) + previousCount);
                    if(countMap.get(popped) == 2) {
                        return popped;
                    }
                } else {
                    previousCount = countMap.getOrDefault(popped, 0);
                }
            }
        }
        return null;
    }
}
