// https://leetcode.com/problems/sort-list/description/

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        return mergeSort(head); 
    }

    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMidNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        ListNode lHead = mergeSort(head);
        ListNode rHead = mergeSort(nhead);
        
        return mergeTwoSortedLinkedList(lHead, rHead);
    }
    
    public ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeTwoSortedLinkedList(ListNode c1, ListNode c2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        
        while(c1 != null && c2 != null) {
            if(c1.val < c2.val) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        
        if(c1 != null) prev.next = c1;
        else prev.next = c2;
        
        return dummyNode.next;
    }
}