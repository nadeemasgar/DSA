// https://leetcode.com/problems/deepest-leaves-sum/description/

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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0) {
            int size = que.size();
            sum = 0;

            while(size-- > 0) {
                TreeNode rem = que.remove();
                sum += rem.val;

                if(rem.left != null) que.add(rem.left);
                
                if(rem.right != null) que.add(rem.right);
            }
        }

        return sum;
    }
}