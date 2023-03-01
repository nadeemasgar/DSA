// https://leetcode.com/problems/delete-leaves-with-a-given-value/description/

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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target);
    }

    public TreeNode helper(TreeNode root, int target) {
        if(root == null) return null;
        
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                return null;
            }
            else {
                return root;
            }
        }
        else {
            root.left = helper(root.left, target);
            root.right = helper(root.right, target);

            if(root.left == null && root.right == null && root.val == target) return null;
            else return root;
        }
    }
}