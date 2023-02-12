// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode node = getMid(head);

        node.next = node.next.next;
        return head;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            
            fast = fast.next.next;
            slow = slow.next;
        }

        return prev;
    }
}