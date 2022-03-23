package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SerializeDeserialize {
    
    public static void main(String[] s) {
        SerializeDeserialize lca = new SerializeDeserialize();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
    
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        System.out.println(lca.serialize(root));
    }
    
   
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
    
          TreeNode(int x) {
              val = x;
          }
      }
     
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        String output = "";
        Map<TreeNode, Boolean> visited = new HashMap<>();
        int treeHieght = hieght(root, 0);
        int i = 1;
        while(queue.size() > 0) {
            TreeNode polled = queue.poll();
            output = output + polled.val + ",";
            if(polled.left != null) {
                queue.add(polled.left);
            }
            if(polled.right != null) {
                queue.add(polled.right);
            }
            if(polled.left != null || polled.right != null) {
                i++;
            }
            if(polled.left == null && i < treeHieght) {
                output = output + "null,";
            }
            if(polled.right == null && i < treeHieght) {
                output = output + "null,";
            }
        }
        return output;
    }
    
    public int hieght(TreeNode node, int h) {
        if(node == null) {
            return h;
        }
        return Math.max(hieght(node.left, h+1), hieght(node.right, h+1));
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Integer[] tree = new Integer[vals.length];
        for(int i = 0; i< vals.length; i++) {
            if(!vals[i].equals("null")) {
                tree[i] = Integer.parseInt(vals[i]);
            } else {
                tree[i] = null;
            }
        }
        TreeNode root = new TreeNode(0);
        TreeNode temp = root;
        for(int i = 0; i< vals.length; i++) {
            temp.val = tree[i];
        }
        
        return null;
    }
}
