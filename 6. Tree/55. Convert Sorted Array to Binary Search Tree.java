// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

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
// SC - O(log n)

class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return buildTree(nums, 0, n-1);
    }

    public TreeNode buildTree(int[] inorder, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        
        int mid = (lo + hi) / 2;
        
        TreeNode node = new TreeNode(inorder[mid]);
        
        node.left = buildTree(inorder, lo, mid-1);
        node.right = buildTree(inorder, mid+1, hi);
        
        return node;
    }
}