// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/

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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.right);
        
        int temp = root.val;
        sum += temp;
        root.val = sum;
        
        inorder(root.left);
    }
}