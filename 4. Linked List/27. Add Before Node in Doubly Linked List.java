// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/add-before-in-doubly-linkedlist/ojquestion

// TC - O(1) for reference Node and O(N) for index
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

   // getFunctions======================================
   private Node getNodeAt(int index) {
    Node curr = this.head;
    while (index-- > 0)
      curr = curr.next;

    return curr;
  }

    // AddFunctions======================================
    public void addBefore(Node refNode, int data) {
      Node node = new Node(data);
      Node prev = refNode.prev;

      if (prev == null) {
        node.next = refNode;
        refNode.prev = node;
        this.head = node;
      } else {
        prev.next = node;
        node.prev = prev;

        node.next = refNode;
        refNode.prev = node;
      }

      this.size++;
    }

    public void addBefore(int idx, int data) {
      Node node = getNodeAt(idx);
      addBefore(node, data);
    }
  }
}
                                