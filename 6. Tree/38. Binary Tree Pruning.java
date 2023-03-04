// https://leetcode.com/problems/binary-tree-pruning/description/

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
// SC - O(h = logn)

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(canDeleteNode(root)) return null;
        return root;
    }

    public boolean canDeleteNode(TreeNode root) {
        if(root.left == null && root.right == null && root.val == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}