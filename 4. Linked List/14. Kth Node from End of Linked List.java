// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/Kth_node_from_end_of_linked_list%20/topic

class Solution {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    public int kthFromLast(int k) {
      Node slow = head;
      Node fast = head;
      for (int i = 0; i < k; i++) {
        fast = fast.next;
      }

      while (fast != tail) {
        slow = slow.next;
        fast = fast.next;
      }

      return slow.data;
    }
  }
}