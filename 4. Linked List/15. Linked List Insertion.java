// https://practice.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node n = new Node(x);
        if(head == null) {
            head = n;
        }
        else {
            n.next = head;
            head = n;
        }
        
        return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        Node n = new Node(x);
        if(head == null) {
            head = n;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        
        return head;
    }
}