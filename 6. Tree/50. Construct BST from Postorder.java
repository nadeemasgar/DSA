// https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1

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

class Solution
{
    static int idx;
    
    public static Node constructTree(int post[],int n)
    {
        idx = post.length - 1;
        return dfs(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static Node dfs(int[] post, int lower, int upper) {
        if (idx < 0) return null;

        int val = post[idx];
        // if the current element 
        // couldn't be placed here to meet BST requirements
        if (val < lower || val > upper) return null;

        // place the current element
        // and recursively construct subtrees
        idx--;
        Node root = new Node(val);
        
        root.right = dfs(post, val, upper);
        root.left = dfs(post, lower, val);
        
        return root;
    }
}