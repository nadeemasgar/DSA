// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/add-after-in-doubly-linkedlist/ojquestion

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
   
    // AddFunctions======================================
    public void addAfter(Node refNode, int data) {
      Node node = new Node(data);
      Node forw = refNode.next;

      if (forw == null) {
        refNode.next = node;
        node.prev = refNode;
        this.tail = node;
      } else {
        forw.prev = node;
        node.next = forw;

        node.prev = refNode;
        refNode.next = node;
      }

      this.size++;
    }

    public void addAfter(int idx, int data) {
      Node node = getNodeAt(idx);
      addAfter(node, data);
    }
  }
}
                                