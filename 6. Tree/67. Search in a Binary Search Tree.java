// https://leetcode.com/problems/search-in-a-binary-search-tree/description/

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        if(val < root.val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }
}