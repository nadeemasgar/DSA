// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-last-in-doubly-linkedlist/ojquestion

// TC - O(1)
// SC - O(1)

class Solution {

  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // Exceptions========================================
    private boolean ListIsEmptyException() {
      if (this.size == 0) {
        System.out.print("ListIsEmpty: ");
        return true;
      }
      return false;
    }

    // RemoveFunctions======================================
    private Node removeLastNode() {
      Node node = this.tail;
      if (this.size == 1)
        this.head = this.tail = null;
      else {
        Node prevNode = this.tail.prev;
        prevNode.next = null;
        node.prev = null;

        this.tail = prevNode;
      }

      this.size--;
      return node;
    }

    public int removeLast() {
      if (ListIsEmptyException())
        return -1;
      Node node = removeLastNode();
      return node.data;
    }
  }
}
                                