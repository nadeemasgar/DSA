// https://leetcode.com/problems/cousins-in-binary-tree/description/

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

class Solution1 {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = 0;
    int yDepth = 0;

    // DFS
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        helper(root, x, y, 0, null);  
        return (xDepth == yDepth) && (xParent != yParent);  
    }

    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null) return;
        
        if(root.val == x) {
            xParent = parent;
            xDepth = depth;
        }
        else if(root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        else {
            helper(root.left, x, y, depth + 1, root);
            helper(root.right, x, y, depth + 1, root);
        }
    }
}

// TC - O(n)
// SC - O(n) 

class Solution2 {
    public boolean isCousins(TreeNode root, int A, int B) {
        if(root == null) return false;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while(que.size() > 0) {
            int size= que.size();
            boolean isAexist = false;
            boolean isBexist = false;
            
            while(size-- > 0 ) {
                TreeNode curr = que.remove();
                if(curr.val == A) isAexist = true;
                if(curr.val == B) isBexist = true;

                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == A && curr.right.val == B) {
                        return false;
                    }
                    if(curr.left.val == B && curr.right.val == A) {
                        return false;
                    }
                }

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }

            if(isAexist && isBexist) return true;
        }

        return false;
    }
}