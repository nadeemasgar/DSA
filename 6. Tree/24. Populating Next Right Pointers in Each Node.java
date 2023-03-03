// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


// TC - O(n) 
// SC - O(1)

class Solution1 {
    public Node connect(Node root) {  
        if (root == null) return root;
        
        Node leftmost = root;
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                
                // CONNECTION 1
                head.left.next = head.right;
                
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            
            // Move onto the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}


// Approach DFS

class Solution2 {
    public Node connect(Node root) {
        if(root == null || root.left == null || root.right == null) {
            return root;
        }

        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}