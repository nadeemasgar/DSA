// https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

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

class Solution {
    public List < Double > averageOfLevels(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}