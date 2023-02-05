// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/addfirst-in-doubly-linkedlist/ojquestion

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

    public void addFirst(int val) {
      Node node = new Node(val);
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
      this.size++;
    }
  }
}
                                
                                
                                
                                