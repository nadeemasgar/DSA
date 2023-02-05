// https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1

// TC - O(n)
// SC - O(1)

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}

class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	    int pos = x - 1; // O-based Indexing
	    Node temp = head;
	    
	    while(pos-- > 0) {
	        temp = temp.next;
	    }
	    
	    Node prev = temp.prev;
	    Node forw = temp.next;
	    
	    if(prev == null) { // starting node
	        head = forw;
	        head.prev = null;
	    }
	    else if(forw == null) { // last node
	        prev.next = null;
	        temp.prev = null;
	    }
	    else {
	        prev.next = temp.next;
	        forw.prev = temp.prev;
	    }
	    
	    temp.prev = temp.next = null;
	    return head;
    }
}