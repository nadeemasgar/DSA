// https://leetcode.com/problems/odd-even-linked-list/description/

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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);

        ListNode temp = head;
        ListNode ptr1 = dummyOdd;
        ListNode ptr2 = dummyEven;

        int idx = 1;

        while(temp != null) {
            if(idx % 2 != 0) { // odd index
                ptr1.next = temp;
                ptr1 = temp;
            }
            else { // even index
                ptr2.next = temp;
                ptr2 = temp;
            }

            temp = temp.next;
            idx++;
        }

        ptr2.next = null;
        ptr1.next = dummyEven.next;
        
        return dummyOdd.next;
    }
}