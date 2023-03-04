// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

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
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int max) {
        if(root == null) return 0;

        int ans = 0;

        if(max <= root.val) ans++;

        max = Math.max(max, root.val);

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        ans += left + right;
        return ans;
    }
}