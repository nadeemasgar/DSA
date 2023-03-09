// https://leetcode.com/problems/trim-a-binary-search-tree/description/

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
    // Time Complexity - O(N);
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) 
        return null;

    // If the value of this node is less than L, then the whole left subtree will be smaller, 
    // so we can discard the left sub tree and return the root of the trimmed right sub tree 
    if (root.val < L) 
        return trimBST(root.right, L, R);

    // If the value of this node is greater than R, then the whole right subtree will be greater
    // so we can discard the right sub tree and return the root of the trimmed left sub tree
    if (root.val > R) 
        return trimBST(root.left, L, R);

    // If the value of this node does not need to be deleted, 
    // we need to pass this recursive call downwards to both sides
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);

    // All the processing of the subtrees done, now return this node
    return root;
}
}