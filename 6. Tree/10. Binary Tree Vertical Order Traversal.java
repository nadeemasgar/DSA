// https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// TC - O(n) 
// SC - O(n)

class Solution {
    public class Pair {
        TreeNode node;
        int X;
        
        Pair(TreeNode node, int X) {
            this.node = node;
            this.X = X;
           
        }
    }

    static int minhl = 0;
    static int maxhl = 0;

    public void width(TreeNode root, int hl) {
        if(root == null) return;

        minhl = Math.min(minhl, hl);
        maxhl = Math.max(maxhl, hl);
      
        width(root.left, hl - 1);
        width(root.right, hl + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        minhl = 0;
        maxhl = 0;

        width(root, 0);
        int width = maxhl - minhl + 1;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            list.add(new ArrayList<>());
        }

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root, -minhl)); // node, X

        while(que.size() > 0) {
            Pair rem = que.remove();

            int idx = rem.X;

            List<Integer> list1 = list.get(idx);
            list1.add(rem.node.val);
            
            if(rem.node.left != null) {
                que.add(new Pair(rem.node.left, rem.X - 1));
            }
            
            if(rem.node.right != null) {
                que.add(new Pair(rem.node.right, rem.X + 1));
            }
        }
        
        return list;
    }
}