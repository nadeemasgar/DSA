// https://practice.geeksforgeeks.org/problems/count-nodes-of-linked-list/0

// TC - O(n)
// SC - O(1)

class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}

class Solution
{
    public static int getCount(Node head)
    {
        int count = 0;
        Node temp = head;
        
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        
        return count;
    }
}