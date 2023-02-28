// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

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

class Solution
{
    void traverseLeft(Node root, ArrayList<Integer> ans) {
        // base code
        if((root == null) || (root.left == null && root.right == null)) 
            return;
            
        ans.add(root.data);
        
        if(root.left != null) {
            traverseLeft(root.left, ans);
        }
        else {
            traverseLeft(root.right, ans);
        }
    }
    
    void traverseLeaf(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            ans.add(root.data);
        }
        
        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }
    
    void traverseRight(Node root, ArrayList<Integer> ans) {
         if((root == null) || (root.left == null && root.right == null)) 
            return;
            
        if(root.right != null) {
            traverseRight(root.right, ans);
        }
        else {
            traverseRight(root.left, ans);
        }
        
        ans.add(root.data);
    }
    
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(root == null) return ans;
	    
	    ans.add(root.data);
	    
	    // left part print
	    traverseLeft(root.left, ans);
	    
	    // leaf part for left subtree
	    traverseLeaf(root.left, ans);
	    
	    // leaf part for right subtree
	    traverseLeaf(root.right, ans);
	    
	    // traverse right part
	    traverseRight(root.right, ans);
	    
	    return ans;
	}
}