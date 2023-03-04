// https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
// https://leetcode.com/problems/house-robber-iii/description/

class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// TC - O(n) 
// SC - O(h = logn)

class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        int[] answer = helper(root);
        return Math.max(answer[0], answer[1]);
    }
    
    static public int[] helper(Node node) {
        // return [rob this node, not rob this node]
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int left[] = helper(node.left);
        int right[] = helper(node.right);
       
        // if we rob this node, we cannot rob its children
        int rob = node.data + left[1] + right[1];
       
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { rob, notRob };
    }
}
