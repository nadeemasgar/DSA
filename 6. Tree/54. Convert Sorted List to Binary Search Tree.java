// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

import java.util.*;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Approach 1: Recursion

// TC - O(n log n)
// SC - O(log n)


class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode slow = head, fast = slow.next;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        
        return root;
    }
}

// Approach 2: Recursion + Conversion to Array

// TC - O(n)
// SC - O(log n)

class Solution2 {

    private List<Integer> values;
  
    public Solution2() {
      this.values = new ArrayList<Integer>();
    }
  
    private void mapListToValues(ListNode head) {
      while (head != null) {
        this.values.add(head.val);
        head = head.next;
      }
    }
  
    private TreeNode convertListToBST(int left, int right) {
      // Invalid case
      if (left > right) {
        return null;
      }
  
      // Middle element forms the root.
      int mid = (left + right) / 2;
      TreeNode node = new TreeNode(this.values.get(mid));
  
      // Base case for when there is only one element left in the array
      if (left == right) {
        return node;
      }
  
      // Recursively form BST on the two halves
      node.left = convertListToBST(left, mid - 1);
      node.right = convertListToBST(mid + 1, right);
      return node;
    }
  
    public TreeNode sortedListToBST(ListNode head) {
  
      // Form an array out of the given linked list and then
      // use the array to form the BST.
      this.mapListToValues(head);
  
      // Convert the array to
      return convertListToBST(0, this.values.size() - 1);
    }
  }