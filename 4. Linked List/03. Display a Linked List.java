// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/display_a_linked_list/topic

class Solution {
    public static class Node {
      int data;
      Node next;
    }
  
    public static class LinkedList {
      Node head;
      Node tail;
      int size;
      
      public void display() {
        Node temp = head;
        while (temp != null) {
          System.out.print(temp.data + " ");
          temp = temp.next;
        }
        System.out.println();
      }
    }
}