// https://www.pepcoding.com/resources/online-java-foundation/linked-lists/linked_list_to_queue_adapter%20/topic

import java.util.*;

class Solution {

  public static class LLToQueueAdapter {
    LinkedList< Integer> list;

    public LLToQueueAdapter() {
      list = new LinkedList< >();
    }

    int size() {
      return list.size();
    }

    void add(int val) {
      list.addLast(val);
    }

    int remove() {
      if (size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        return list.removeFirst();
      }
    }

    int peek() {
      if (size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      } else {
        return list.getFirst();
      }
    }
  }
}