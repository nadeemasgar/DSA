// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/

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
    int maxLcs = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, root.val - 1, 0);

        return maxLcs;
    }

    public void helper(TreeNode root, int preVal, int lcs) {
        if(root == null) return;

        if(preVal + 1 == root.val) {
            lcs++;
        }
        else {
            lcs = 1;
        }

        maxLcs = Math.max(maxLcs, lcs);

        helper(root.left, root.val, lcs);

        helper(root.right, root.val, lcs);
    }
}