// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

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
        TreeNode node = null;
        int idx = 0;

        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new ArrayDeque<>();
        int max = 0;

        que.add(new Pair(root, 0));
        while(que.size() > 0) {
            int size = que.size();
            int leftMost = que.peek().idx;
            int rightMost = que.peek().idx;

            while(size-- > 0) {
                Pair rem = que.remove();
                rightMost = rem.idx;

                if(rem.node.left != null) {
                    que.add(new Pair(rem.node.left, rem.idx * 2 + 1));
                }

                if(rem.node.right != null) {
                    que.add(new Pair(rem.node.right, rem.idx * 2 + 2));
                }
            }

            max = Math.max(max, rightMost - leftMost + 1);
        }

        return max;      
    }
}