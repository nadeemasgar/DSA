// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0) {
            int size = que.size();
            ArrayList<Integer> list = new ArrayList<>();

            while(size-- > 0) {
                TreeNode rem = que.remove();
                list.add(rem.val);

                if(rem.left != null) que.add(rem.left);

                if(rem.right != null) que.add(rem.right);
            }

            res.add(list);
        }

        return res;
    }
}