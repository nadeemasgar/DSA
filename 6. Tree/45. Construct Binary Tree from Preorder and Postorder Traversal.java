// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if(preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);

        if(preStart == preEnd) return root;

        int postIndex = postStart;
        while(post[postIndex] != pre[preStart + 1]) postIndex++;

        int len = postIndex - postStart + 1;

        root.left = dfs(pre, preStart + 1, preStart + len, post, postStart, postIndex);
        root.right = dfs(pre, preStart + len + 1, preEnd, post, postIndex + 1, postEnd - 1);

        return root;
    }
}