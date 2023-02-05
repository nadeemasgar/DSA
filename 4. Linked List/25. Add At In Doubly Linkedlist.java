// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/add-at-in-doubly-linkedlist/ojquestion

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

    // AddFunctions======================================
    private void addFirstNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
      this.size++;
    }

    private void addLastNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
      }
      this.size++;
    }

    private void addNodeAt(int index, Node node) {
      if (index == 0)
        addFirstNode(node);
      else if (index == this.size)
        addLastNode(node);
      else {
        Node forw = getNodeAt(index);
        Node prev = forw.prev;

        prev.next = node;
        node.prev = prev;

        node.next = forw;
        forw.prev = node;

        this.size++;
      }
    }

    public void addAt(int index, int data) {
      if (indexIsInvalidException(index, 0, this.size))
        System.out.println(-1);
      else {
        Node node = new Node(data);
        addNodeAt(index, node);
      }
    }
  }
}
                                