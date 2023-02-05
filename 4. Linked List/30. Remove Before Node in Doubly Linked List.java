// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-before-in-doubly-linkedlist/ojquestion

// TC - O(1) for reference Node and O(N) for index
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

    // getFunctions======================================
    private Node getNodeAt(int index) {
        Node curr = this.head;
        while (index-- > 0)
          curr = curr.next;
  
        return curr;
    }

    // RemoveFunctions======================================
    private Node removeBeforeNode(Node refNode) {
      Node prevNode = refNode.prev;
      if (prevNode.prev == null) {
        refNode.prev = null;
        prevNode.next = null;
        this.head = refNode;
      } else {
        refNode.prev = prevNode.prev;
        prevNode.prev.next = refNode;

        prevNode.next = null;
        prevNode.prev = null;
      }
      this.size--;
      return prevNode;
    }

    public int removeBefore(Node refNode) {
      if (refNode.prev == null) {
        System.out.print("LocationIsInvalid: ");
        return -1;
      }
      return removeBeforeNode(refNode).data;
    }

    public int removeBefore(int idx) {
      Node node = getNodeAt(idx);
      return removeBefore(node);
    }
  }
}
                                