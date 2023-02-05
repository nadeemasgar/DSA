// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-first-in-doubly-linkedlist/ojquestion

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
        System.out.print("ListIsEmpty: " );
        return true;
      }
      return false;
    }

    // RemoveFunctions======================================
    private Node removeFirstNode() {
      Node node = this.head;
      if (this.size == 1)
        this.head = this.tail = null;
      else {
        Node nextNode = this.head.next;
        nextNode.prev = null;
        node.next = null;

        this.head = nextNode;
      }

      this.size--;
      return node;
    }

    public int removeFirst() {
      if (ListIsEmptyException())
        return -1;
      Node node = removeFirstNode();
      return node.data;
    }

  }
}
                                