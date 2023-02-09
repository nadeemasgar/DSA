// https://leetcode.com/problems/reverse-linked-list-ii/description/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // Till the left index
       ListNode cur1 = dummy;
        ListNode pre1 = null;
        for(int i = 0; i < left; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        // reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;

        // reversing a linked list
        for(int i = left; i <= right; i++) {
            ListNode forw = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = forw;
        }

        // connect
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }
}