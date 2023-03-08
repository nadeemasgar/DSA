// https://practice.geeksforgeeks.org/problems/cousins-of-a-given-node/1

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// TC - O(n)
// SC - O(n)

class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        boolean flag = true;
        
        while(que.size() > 0 && flag) {
            int size = que.size();
            
            while(size -- > 0) {
                Node node = que.remove();
                 
                if(node.left == node_to_find || node.right == node_to_find) {
                    flag = false;
                }
                else {
                    if(node.left != null) que.add(node.left);
                
                    if(node.right != null) que.add(node.right);
                }
            } 
        } 
        
        if(que.isEmpty()) {
            return new ArrayList<>(Arrays.asList(-1)); 
        }
        else {
            
            ArrayList<Integer> res = new ArrayList<>();
            
            while(que.size() > 0) {
                res.add(que.remove().data);
            }
            
            return res;
        }
    }
}