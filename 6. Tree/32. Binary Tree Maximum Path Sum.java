// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

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
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxSum;
    }

    public int getMaxPathSum(TreeNode root) {
        if(root == null) return 0;

        int gainFromLeft = Math.max(getMaxPathSum(root.left), 0);

        int gainFromRight = Math.max(getMaxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }
}