// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1

// TC - O(n)
// SC - O(1)


class Node {
    int data;
    Node next;
}


class Solution {
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if(head == null) return;

        Node intersect = getIntersect(head);
        if(intersect == null) return;
        
        /* This case is added if fast and slow pointer meet at head position. */
        if(intersect == head) {
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            
            temp.next = null;  // Cycle break
        }
        else {
            Node ptr1 = head;
            Node ptr2 = intersect;
        
            Node prev = null;
            
            while(ptr1 != ptr2) {
                prev = ptr2;
                
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            prev.next = null; // Cycle break
        }
    }
    
    public static Node getIntersect(Node head) {
        Node slow = head;
        Node fast = head;

         while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return slow;
            }
        }

        return null;
    }
}