// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/remove-node-in-doubly-linkedlist/ojquestion

// TC - O(1) for reference node
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

    // RemoveFunctions======================================
    public int removeNode(Node refNode) {
        Node prev = refNode.prev;
        Node forw = refNode.next;
        if(this.size == 1)
            this.head = this.tail = null;
        else if(prev == null) 
           this.head = forw;
        else if(forw == null)
           this.tail = prev;
        else{
            prev.next = forw;
            forw.prev = prev;
        }
      
        refNode.prev = refNode.next = this.head.prev = this.tail.next = null;
        this.size--;
        return refNode.data;
    }
  }
}
                                