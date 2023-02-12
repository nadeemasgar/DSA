// https://leetcode.com/problems/partition-list/

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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode temp1 = left , temp2 = right;
      
        ListNode iterator = head;
        while(iterator != null){
            if(iterator.val < x){
                temp1.next = iterator;
                temp1 = temp1.next;
            }
            else{
                temp2.next = iterator;
                temp2 = temp2.next;
            }

           iterator = iterator.next;
        }

        temp1.next = right.next;
        temp2.next = null; // important

        return left.next;
    }
}