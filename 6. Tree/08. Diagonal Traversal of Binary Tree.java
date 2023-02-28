// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

// TC - O(n) 
// SC - O(n)

class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        
        while(que.size() > 0) {
            
            Node curr = que.remove();
            
            while(curr != null) {
                res.add(curr.data);
                
                if(curr.left != null) {
                    que.add(curr.left);
                }
                
                curr = curr.right;
            }
        }
        
        return res;
    }
}
