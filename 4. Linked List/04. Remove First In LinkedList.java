// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/remove_first_in_linked_list/topic

class Solution {
    public static class Node {
      int data;
      Node next;
    }
  
    public static class LinkedList {
      Node head;
      Node tail;
      int size; 
  
      public void removeFirst() {
        if (size == 0) {
          System.out.println("List is empty");
        } else if (size == 1) {
          head = tail = null;
          size--;
        } else {
          head = head.next;
          size--;
        }
      }
    }
}