// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// TC - O(n) 
// SC - O(n)

class Pair {
    Node node;
    int hl;
    
    Pair(Node node,int hl) {
        this.node = node;
        this.hl = hl;
    }
}

class Solution
{
    static int minhl;
    static int maxhl;
    
    public static void width(Node node,int hl) {
        if(node == null) {
            return;
        }
        
        minhl = Math.min(minhl,hl);
        maxhl = Math.max(maxhl,hl);
        
        width(node.left,hl-1);
        width(node.right,hl+1);
    }
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer>ans = new ArrayList<>();
        
        minhl = 0;
        maxhl = 0;
        width(root, 0);
        
        int w = maxhl - minhl + 1;
        
        for(int i = 0; i < w; i++) {
            ans.add(null);
        }
        
        Queue<Pair> que = new ArrayDeque<>();
        int blev = -minhl; //base level
        
        que.add(new Pair(root,blev));
        
        while(que.size() > 0) {
            //remove
            Pair rem = que.remove();
            
            //work
           ans.set(rem.hl,rem.node.data);
            
            
            //add children
            if(rem.node.left != null) {
                que.add(new Pair(rem.node.left,rem.hl-1));
            }
            if(rem.node.right != null) {
                que.add(new Pair(rem.node.right,rem.hl+1));
            }
        }
        
        return ans;
    }
}