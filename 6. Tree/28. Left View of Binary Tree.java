// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

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

class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
    
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.add(root);
        
        while(que.size() > 0) {
            
            int size = que.size();
            res.add(que.peek().data);
            
            while(size-- > 0) {
                
                Node rem = que.remove();
                
                if(rem.left != null) {
                    que.add(rem.left);
                }
                
                if(rem.right != null) {
                    que.add(rem.right);
                }
            }
        } 
        
        return res;
    }
}