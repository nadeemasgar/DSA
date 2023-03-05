// https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1

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

// TC - O(n ^ 2)
// SC - O(n)

class Solution {
    Node buildTree(int inord[], int level[])
    {
        // construct a value-to-index map for level order traversal
        HashMap<Integer, Integer> levelOrderMap = new HashMap<>();
        
        for(int i = 0; i < level.length; i++) {
            levelOrderMap.put(level[i], i);
        }
        
        return dfs(inord, levelOrderMap, 0, inord.length - 1);
    }
    
    public Node dfs(int[] inord, HashMap<Integer, Integer> levelOrderMap, int inStart, int inEnd) {
        if(inStart > inEnd) return null;
        
        // find node with minimum index in level-order traversal
        // that would be the root of inorder[start, end]
        
        int min_index = inStart;
        
        for(int i = inStart + 1; i <= inEnd; i++) {
            int temp = inord[i];
            //if current element from inorder have least index in 
            //levelorder map, update min_index
            if(levelOrderMap.get(inord[min_index]) > levelOrderMap.get(temp))
                min_index = i;
        }
        
        Node root = new Node(inord[min_index]);
        
        if(inStart == inEnd) return root;
        
        root.left = dfs(inord, levelOrderMap, inStart, min_index - 1);
        root.right = dfs(inord, levelOrderMap, min_index + 1, inEnd);
        
        return root;
    }
}