// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/display-forward-and-backward-in-doubly-linkedlist/ojquestion

// TC - O(n)
// SC - O(n)

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

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      return sb.toString();
    }

    // DisplayFunctions======================================
    public void displayForw() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      System.out.println(sb.toString());
    }

    public void displayBack() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.tail;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.prev != null)
          sb.append(", ");
        curr = curr.prev;
      }
      sb.append("]");

      System.out.println(sb.toString());
    }
  }
}

                                