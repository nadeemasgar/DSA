// https://leetcode.com/problems/binary-tree-cameras/description/

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
    int cam = 0;

    public int minCameraCover(TreeNode root) {
        int ans = dfs(root);
        // (0) -> cam + 1, (1,2) --> cam
        return ans == 0 ? cam + 1 : cam; 
    }

    // 2 --> Has Camera
    // 1 --> Covered with the Camera
    // 0 --> No Camera is covering this node
    public int dfs(TreeNode root) {
        if(root == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 0 || right == 0) {
            cam++;
            return 2;
        }
        else if(left == 2 || right == 2) return 1;
        else return 0;
    }
}