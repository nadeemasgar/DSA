// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

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

// TC - O(n ^ 2) in case of skewed tree
// SC - O(n)

class Solution1 {
    public TreeNode buildTree(int[] in, int[] post) {
        return dfs(in, 0, in.length - 1, post, post.length - 1);
    }

    public TreeNode dfs(int[] in, int inStart, int inEnd, int[] post, int index) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(post[index]);

        if(inStart == inEnd) return root;
        
        int inRootIndex = inStart;
        while(in[inRootIndex] != post[index]) inRootIndex++;

        root.right = dfs(in, inRootIndex + 1, inEnd, post, index - 1);
        root.left = dfs(in, inStart, inRootIndex - 1, post, index - (inEnd - inRootIndex) - 1);

        return root;
    }
}

// TC - O(n)
// SC - O(n)

class Solution2 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] in, int[] post) {
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return dfs(in, 0, in.length - 1, post, post.length - 1);
    }

    public TreeNode dfs(int[] in, int inStart, int inEnd, int[] post, int index) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(post[index]);

        if(inStart == inEnd) return root;

        int inRootIndex = map.get(post[index]);

        root.right = dfs(in, inRootIndex + 1, inEnd, post, index - 1);
        root.left = dfs(in, inStart, inRootIndex - 1, post, index - (inEnd - inRootIndex) - 1);

        return root;
    }
}