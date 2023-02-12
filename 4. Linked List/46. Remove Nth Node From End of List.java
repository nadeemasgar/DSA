// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while(n > 0) {
            curr = curr.next;
            n--;
        }

        ListNode prev = dummy;
        while(curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return dummy.next;
    }
}