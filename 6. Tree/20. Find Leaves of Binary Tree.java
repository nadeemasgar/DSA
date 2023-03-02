// https://leetcode.com/problems/find-leaves-of-binary-tree/description/

import java.util.*;

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        level(root, ans);
        return ans;
    }

    public int level(TreeNode root, List<List<Integer>> ans) {
        if(root == null) return -1;
        int leftLevel = level(root.left, ans);
        int rightLevel = level(root.right, ans);

        int currLevel = Math.max(leftLevel, rightLevel) + 1;

        if(ans.size() <= currLevel) {
            ans.add(new ArrayList<>());
        }

        ans.get(currLevel).add(root.val);

        return currLevel;
    }
}