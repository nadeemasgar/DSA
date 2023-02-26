// https://leetcode.com/problems/binary-tree-preorder-traversal/

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

// Recursive Approach
// TC - O(n) 
// SC - O(n)

class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);

        return list;
    }

    public void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}

// Iterative Approach
// TC - O(n) 
// SC - O(n)

class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        while(curr != null || st.size() > 0 ) {
            while(curr != null) {
                st.push(curr);
                list.add(curr.val);
                curr = curr.left;
            }

            curr = st.pop();
            curr = curr.right;
        }

        return list;
    }
}