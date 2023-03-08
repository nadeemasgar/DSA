// https://leetcode.com/problems/closest-binary-search-tree-value/description/

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
// SC - O(1)

class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        
        while(root != null) {
          if(Math.abs(target - root.val) < Math.abs(target - res)) {
            res = root.val;
          }

          if(target < root.val) 
            root = root.left;
          else 
            root = root.right;
        }

        return res;
    }
}