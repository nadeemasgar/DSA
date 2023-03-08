// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

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
    public TreeNode insertIntoBST(TreeNode root, int data) {
        
        if(root == null) {
            TreeNode node = new TreeNode(data, null, null);
            return node;
        }

        if(data > root.val) {
            root.right = insertIntoBST(root.right, data);
        }
        else if(data < root.val) {
            root.left = insertIntoBST(root.left, data);
        }

        return root;
    }
}