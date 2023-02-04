// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/add_last_in_linked_list/topic

class Solution {
    public static class Node {
      int data;
      Node next;
    }
  
    public static class LinkedList {
      Node head;
      Node tail;
      int size;
  
      void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
  
        if (size == 0) {
          head = tail = temp;
        } else {
          tail.next = temp;
          tail = temp;
        }
  
        size++;
      }
    }
}