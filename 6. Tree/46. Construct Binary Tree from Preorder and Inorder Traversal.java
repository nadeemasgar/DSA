// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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
    public TreeNode buildTree(int[] pre, int[] in) {
        return dfs(in, 0, in.length - 1, pre, 0);
    }

    public TreeNode dfs(int[] in, int inStart, int inEnd, int[] pre, int index) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[index]);

        if(inStart == inEnd) return root;

        int inRootIndex = inStart;
        while(in[inRootIndex] != pre[index]) inRootIndex++;

        root.left = dfs(in, inStart, inRootIndex - 1, pre, index + 1);
        root.right = dfs(in, inRootIndex + 1, inEnd, pre, index + (inRootIndex - inStart) + 1);

        return root;
    }
}

// TC - O(n)
// SC - O(n)

class Solution2 {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] pre, int[] in) {
        for(int idx = 0; idx < in.length; idx++) {
            map.put(in[idx], idx);
        }
        return dfs(in, 0, in.length - 1, pre, 0);
    }

    public TreeNode dfs(int[] in, int inStart, int inEnd, int[] pre, int index) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[index]);

        if(inStart == inEnd) return root;

        int inRootIndex = map.get(pre[index]);

        root.left = dfs(in, inStart, inRootIndex - 1, pre, index + 1);
        root.right = dfs(in, inRootIndex + 1, inEnd, pre, index + (inRootIndex - inStart) + 1);

        return root;
    }
}