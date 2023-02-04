// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/reverse_linked_list_pointer_iterative/topic

class Solution {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;


    public void reversePI() {
      Node prev = null;
      Node curr = head;

      while (curr != null) {
        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }

      Node t = head;
      head = tail;
      tail = t;
    }
  }
}