// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-at-in-doubly-linkedlist/ojquestion

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

    
    private Node removeAtNode(int index) {
      if (index == 0)
        return removeFirstNode();
      else if (index == this.size - 1)
        return removeLastNode();
      else {
        Node node = getNodeAt(index);
        Node prev = node.prev;
        Node forw = node.next;

        prev.next = forw;
        forw.prev = prev;

        node.next = null;
        node.prev = null;

        this.size--;
        return node;
      }
    }

    public int removeAt(int index) {
      if (ListIsEmptyException())
        return -1;
      if (indexIsInvalidException(index, 0, this.size - 1))
        return -1;

      Node node = removeAtNode(index);
      return node.data;
    }
  }
}
                                