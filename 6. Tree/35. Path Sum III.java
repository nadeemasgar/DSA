// https://leetcode.com/problems/path-sum-iii/description/

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
    int count = 0;
    int k;
    HashMap<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        helper(root, 0L);
        return count;  
    }

    public void helper(TreeNode node, long currSum) {
        if(node == null) return;
        
        currSum += node.val;

        if(currSum == k) {
            count++;
        }

        count += map.getOrDefault(currSum - k, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        helper(node.left, currSum);
        helper(node.right, currSum);

        map.put(currSum, map.get(currSum) - 1);
    }
}