// https://leetcode.com/problems/unique-binary-search-trees-ii/description/

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

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        if(start > end) {
            list.add(null);
            return list;
        }

        if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        for(int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            List<TreeNode> leftPossibleTrees = helper(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            List<TreeNode> rightPossibleTrees = helper(i + 1, end);

            // connect left and right trees to the root i
            for(TreeNode lRoot : leftPossibleTrees) {
                for(TreeNode rRoot : rightPossibleTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    list.add(root);
                }
            }
        }

        return list;
    }
} 