// https://leetcode.com/problems/delete-node-in-a-bst/description/

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

// TC - O(log n)
// SC - O(h) ~ log n

class Solution {
    public TreeNode deleteNode(TreeNode root, int data) {
        if (root == null) return null;

        if (data > root.val) {
            root.right = deleteNode(root.right, data);
        } 
        else if (data < root.val) {
            root.left = deleteNode(root.left, data);
        } 
        else {
            if (root.left == null && root.right == null) return null; // leaf node
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                int max = max(root.left);
                root.val = max;
                root.left = deleteNode(root.left, max);
            }
        }

        return root;
    }

    public int max(TreeNode node) {
        if (node.right == null) {
        return node.val;
        } else {
        return max(node.right);
        }
    }
}