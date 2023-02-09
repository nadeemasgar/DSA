// https://practice.geeksforgeeks.org/problems/find-length-of-loop/1

// TC - O(n)
// SC - O(1)

class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

//Function should return the length of the loop in LL.
class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return countNodes(slow);
            }
        }

        return 0;
    }

    static public int countNodes(Node ptr) {
        
        Node temp = ptr;
        int length = 1;

        while(temp.next != ptr) {
            length++;
            temp = temp.next;
        }

        return length;
    }
}