// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// TC - O(n)
// SC - O(h = logn)

class Solution {
    public int maxDepth(Node node) {
        if(node == null) return 0;
        
        int height = 0;
    
        for(Node child : node.children) {
            height = Math.max(height, maxDepth(child));
        }
    
        return height + 1;
    }
}