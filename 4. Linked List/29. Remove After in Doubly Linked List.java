// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-after-in-doubly-linkedlist/ojquestion

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
    private Node removeAfterNode(Node refNode) {
      Node forw = refNode.next;
      if (forw.next == null) {
        refNode.next = null;
        forw.prev = null;

        this.tail = refNode;
      } else {
        refNode.next = forw.next;
        forw.next.prev = refNode;

        forw.next = null;
        forw.prev = null;
      }
      this.size--;
      return forw;
    }

    public int removeAfter(Node refNode) {
      if (refNode.next == null) {
        System.out.print("LocationIsInvalid: ");
        return -1;
      }
      return removeAfterNode(refNode).data;
    }

    public int removeAfter(int idx) {
      Node node = getNodeAt(idx);
      return removeAfter(node);
    }
  }
}

                                