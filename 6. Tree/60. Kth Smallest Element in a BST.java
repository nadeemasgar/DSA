// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

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
    int kSmallest;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        kSmallest = Integer.MAX_VALUE;
        count = k;
        kthSmallestHelper(root);
        return kSmallest;
    }
    
    public void kthSmallestHelper(TreeNode root) {
        if(root == null)
            return;
        
        kthSmallestHelper(root.left);
        
        count--;
        if(count == 0) {
            kSmallest = root.val;
            return;
        }
        
        kthSmallestHelper(root.right);
    }
}