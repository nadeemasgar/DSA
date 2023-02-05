// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/get-at-in-doubly-linkedlist/ojquestion

// TC - O(n)
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

    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
      if (index < leftRange || index > rightRange) {
        System.out.print("IndexIsInValid: ");
        return true;
      }
      return false;
    }

    // getFunctions======================================
    private Node getNodeAt(int index) {
      Node curr = this.head;
      while (index-- > 0)
        curr = curr.next;

      return curr;
    }

    public int getAt(int index) {
      if (ListIsEmptyException())
        return -1;
      else if (indexIsInvalidException(index, 0, this.size - 1))
        return -1;

      Node node = getNodeAt(index);
      return node.data;
    }
  }
}
                                
                                
                                