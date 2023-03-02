// https://leetcode.com/problems/find-bottom-left-tree-value/description/

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        TreeNode node = null;
        
        while(que.size() > 0) {
            node = que.remove();
            if(node.right != null) {
                que.add(node.right);
            }

            if(node.left != null) {
                que.add(node.left);
            }
        }

        return node.val;
    }
}