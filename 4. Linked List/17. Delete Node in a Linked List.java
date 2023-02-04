// https://leetcode.com/problems/delete-node-in-a-linked-list/description/

// TC - O(1)
// SC - O(1)

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}