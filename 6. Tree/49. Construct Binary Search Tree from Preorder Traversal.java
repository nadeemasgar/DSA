// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

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
    int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int lower, int upper) {
        if (idx == preorder.length) return null;

        int val = preorder[idx];
        // if the current element 
        // couldn't be placed here to meet BST requirements
        if (val < lower || val > upper) return null;

        // place the current element
        // and recursively construct subtrees
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, lower, val);
        root.right = dfs(preorder, val, upper);
        return root;
    }
}