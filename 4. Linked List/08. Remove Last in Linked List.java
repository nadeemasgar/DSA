// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/remove_last_in_linked_list/topic

class Solution {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
      }
    }
  }
}