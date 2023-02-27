// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> par = new Stack<>();
        par.push(root);

        int flag = 0;
        
        while(par.size() > 0) {
            int size = par.size();
            Stack<TreeNode> child = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();

            while(size-- > 0) {
                TreeNode rem = par.pop();
                list.add(rem.val);

                if(flag % 2 == 0) {
                    if(rem.left != null) child.push(rem.left);
                    if(rem.right != null) child.push(rem.right);
                }
                else {
                    if(rem.right != null) child.push(rem.right);
                    if(rem.left != null) child.push(rem.left);
                }
            }

            res.add(list);
            par = child;
            flag++;
        }

        return res;
    }
}