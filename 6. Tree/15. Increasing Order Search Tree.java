// https://leetcode.com/problems/increasing-order-search-tree/description/

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

// Approach 1: In-Order Traversal

class Solution1 {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(0);
        TreeNode curr = ans;

        for(int val: list) {
            TreeNode node = new TreeNode(val);
            curr.right = node;
            curr = curr.right;
        }

        return ans.right;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

// Approach 2: Traversal with Relinking

class Solution2 {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        
        root.left = null;
        curr.right = root;
        curr = root;

        inorder(root.right);
    }
}

