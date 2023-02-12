// https://leetcode.com/problems/reorder-list/description/

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/* Recursive Approach */

class Solution1 {
    ListNode fleft;
    int size;

    public void reorderList(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            n++;
        }

        size = n;
        fleft = head;
        
        foldHelper(head, 0);
    }

    public void foldHelper(ListNode right, int floor) {
        if (right == null) {
            return;
        }

        foldHelper(right.next, floor + 1);
        if (floor > size / 2) {
            ListNode temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        } 
        else if (floor == size / 2) { // for setting up the tail next as null
            right.next = null;
        }
    }
}

/* Iterative Approach */

// TC - O(n)
// SC - O(n)

class Solution2 {
    public void reorderList(ListNode head) {
      if (head == null) return;
  
      // find the middle of linked list [Problem 876]
      // in 1->2->3->4->5->6 find 4 
      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
  
      // reverse the second part of the list [Problem 206]
      // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
      // reverse the second half in-place
      ListNode prev = null, curr = slow;
      while(curr != null) {
          ListNode forw = curr.next;
              
          curr.next = prev;
  
          prev = curr;
          curr = forw;
      }
      // prev -> head of reverse Linked List
  
      // merge two sorted linked lists [Problem 21]
      // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
      ListNode first = head, second = prev; 
      while (second.next != null) {
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;
  
        first.next = second;
        second.next = temp1;
  
        first = temp1;
        second = temp2;
      }
    }
  }