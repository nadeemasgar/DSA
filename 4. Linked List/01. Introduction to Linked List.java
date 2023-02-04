// https://practice.geeksforgeeks.org/problems/introduction-to-linked-list/1


class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 


class Solution {
    static Node constructLL(int arr[]) {
        Node head = null;
        Node curr = null;
        
        for(int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            
            if(i == 0) {
                head = n;
                curr = n;
            }
            else {
                curr.next = n;
                curr = n;
            }
        }
        
        return head;
    }
}


