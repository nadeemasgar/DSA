// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

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
    int minDistance = Integer.MAX_VALUE;
    TreeNode prevValue;

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDistance;
    }

    void inorderTraversal(TreeNode root) {
        if (root == null) return;
    
        inorderTraversal(root.left);

        // Find the difference with the previous value if it is there.
        if (prevValue != null) {
            minDistance = Math.min(minDistance, root.val - prevValue.val);
        }
        prevValue = root;

        inorderTraversal(root.right);
    }
};