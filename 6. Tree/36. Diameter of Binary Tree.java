// https://leetcode.com/problems/diameter-of-binary-tree/description/

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
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
     
    int dia = 0;
    public int height(TreeNode node) {
        if (node == null) return -1;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        dia = Math.max(dia, leftHeight + rightHeight + 2);
        
        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
}