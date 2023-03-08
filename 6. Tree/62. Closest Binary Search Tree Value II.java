// https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        inorder(root, target, k, res);
        return res;
    }

    public void inorder(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if(root == null) return;

        inorder(root.left, target, k, res);

        if(res.size() == k) {
            if(Math.abs(target - root.val) < Math.abs(target - res.peek())) {
                res.remove();
            }
            else {
                return;
            }
        }

        res.add(root.val);

        inorder(root.right, target, k, res);
    }
}