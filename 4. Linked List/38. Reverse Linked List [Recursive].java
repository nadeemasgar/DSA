// https://leetcode.com/problems/reverse-linked-list/description/

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode res_head = reverseList(head.next);
        
        ListNode res_tail = head.next;
        res_tail.next = head;
        head.next = null;

        return res_head;
    }
}