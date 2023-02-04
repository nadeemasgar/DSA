// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/add_first_in_linked_list/topic

class Solution {
    public static class Node {
      int data;
      Node next;
    }
  
    public static class LinkedList {
      Node head;
      Node tail;
      int size;

      public void addFirst(int val) {
        Node t = new Node();
        t.data = val;
        t.next = head;
        if (size == 0)
        {
          tail = t;
        }
        head = t;
        size++;
      }
    }
}