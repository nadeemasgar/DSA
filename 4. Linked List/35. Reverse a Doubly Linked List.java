// https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1

// TC - O(n)
// SC - O(1)

class Node {
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Solution {

    public static Node reverseDLL(Node head)
    {
        Node curr = head;
        Node prev = null;
        
        while(curr != null) {
            curr.prev = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = curr.prev;
        }
    
        return prev;
    }
}
