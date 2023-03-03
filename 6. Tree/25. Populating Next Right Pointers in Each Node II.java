// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.*;

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
// SC - O(n)

class Solution1 {
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        while(que.size() > 0) {
            int size = que.size();
            Node dummy = new Node(0);

            while(size-- > 0) {
                Node rem = que.remove();
                dummy.next = rem;
                dummy = dummy.next;

                if(rem.left != null) {
                    que.add(rem.left);
                }

                if(rem.right != null) {
                    que.add(rem.right);
                }
            }
        }

        return root;
    }
}

// TC - O(n) 
// SC - O(1)

class Solution2 {
    public Node connect(Node root) {
        if(root == null) return null;

        Node head = root;

        while(head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;

            while(head != null) {
                if(head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }

                if(head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }
}