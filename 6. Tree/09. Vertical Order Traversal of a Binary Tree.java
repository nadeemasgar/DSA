// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

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

// TC - O(n log(n)) 
// SC - O(n)

class Solution {
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int X;
        int Y;

        Pair(TreeNode node, int X, int Y) {
            this.node = node;
            this.X = X;
            this.Y = Y;
        }

        public int compareTo(Pair o) {
            if(this.Y != o.Y) {
                return this.Y - o.Y;
            }
            else if(this.X != o.X) {
                return this.X - o.X;
            }
            else {
                return this.node.val - o.node.val;
            }
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        minhl = 0;
        maxhl = 0;

        width(root, 0);
        int width = maxhl - minhl + 1;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            list.add(new ArrayList<>());
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root, -minhl, 0)); // node, X, Y

        while(pq.size() > 0) {
            Pair rem = pq.remove();

            int idx = rem.X;

            List<Integer> list1 = list.get(idx);
            list1.add(rem.node.val);
            
            if(rem.node.left != null) {
                pq.add(new Pair(rem.node.left, rem.X - 1, rem.Y + 1));
            }
            
            if(rem.node.right != null) {
                pq.add(new Pair(rem.node.right, rem.X + 1, rem.Y + 1));
            }
        }
        
        return list;
    }
}