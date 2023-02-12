// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

// TC - O(n)
// SC - O(1)

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int pairSum(ListNode head) {
         if (head == null) return 0;
  
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

        ListNode first = head, second = prev; 
        int max = 0;
        while(second != null) {
            max = Math.max(max, first.val + second.val);

            first = first.next;
            second = second.next;
        }

        return max;
    }
}