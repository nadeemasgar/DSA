// https://practice.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1

// TC - O(n)
// SC - O(1)

class Node {
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}

class Solution {
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head, int pos, int data)
	{
	    Node n = new Node(data);
	    
		Node temp = head;
		while(pos-- > 0) {
		    temp = temp.next;
		}
		
		Node forw = temp.next;
		
		if(forw == null) {
		    temp.next = n;
		    n.prev = temp;
		}
		else {
		    temp.next = n;
		    n.prev = temp;
		    
		    n.next = forw;
		    forw.prev = n;
		}
	}
}