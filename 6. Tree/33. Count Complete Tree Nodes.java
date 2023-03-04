// https://leetcode.com/problems/count-complete-tree-nodes/description/

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

// TC - O(Log^2 N)
// SC - O(n)

class Solution1 {
    public int countNodes(TreeNode root) {
        if(root == null) return  0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }
}

// TC - O(n) 
// SC - O(n)

class Solution2 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftheight = getHeightLeft(root);
        int rightheight = getHeightRight(root);
        
        if(leftheight == rightheight) {
            return ((1 << leftheight) - 1);
        }
         
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        
        return left + right + 1;
    }
    
    public int getHeightLeft(TreeNode root) {
        int count = 1;
        while(root.left != null) {
            root = root.left;
            count++;
        }
        
        return count;
    }
    
     public int getHeightRight(TreeNode root) {
        int count = 1;
        while(root.right != null) {
            root = root.right;
            count++;
        }
        
        return count;
    }
}