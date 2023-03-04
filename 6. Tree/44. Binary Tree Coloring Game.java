// https://leetcode.com/problems/binary-tree-coloring-game/description/

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
// SC - O(h)

class Solution {
    int lc; // left subTree count 
    int rc; // right subTree count
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc = 0;
        rc = 0;
        count(root, x);

        int nnpex = n - (lc + rc + 1); // number of nodes in parent 
        int max = Math.max(nnpex, Math.max(lc, rc));

        return max > (n / 2);
    }

    public int count(TreeNode root, int x) {
        if(root == null) return 0;

        int left = count(root.left, x);
        int right = count(root.right, x);

        if(root.val == x) {
            lc = left;
            rc = right;
        }
        return left + right + 1;
    }
}