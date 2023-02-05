// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/get-first-and-get-last-in-doubly-linkedlist/ojquestion

// TC - O(1)
// SC - O(1)

class Solution {
    
  public static class DoublyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }
    }

    // Exceptions========================================
    private boolean ListIsEmptyException() {
      if (this.size == 0) {
        System.out.print("ListIsEmpty: ");
        return true;
      }
      return false;
    }

    // BasicFunctions======================================
    public int size() {
      return this.size;
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    // getFunctions======================================
    public int getFirst() {
      if (ListIsEmptyException())
        return -1;

      return this.head.data;
    }

    public int getLast() {
      if (ListIsEmptyException())
        return -1;

      return this.tail.data;
    }
  }
}
                                
                                
                                