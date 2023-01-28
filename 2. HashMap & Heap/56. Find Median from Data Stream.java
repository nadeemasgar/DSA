// https://leetcode.com/problems/find-median-from-data-stream/description/

// TC - O(log n)
// SC - O(n)

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());    
    }
    
    public void addNum(int num) {   

        if(maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(num);
        }   
        else {
            
            if(maxHeap.peek() < num) {
                minHeap.add(num);
            }
            else {
                maxHeap.add(num);
            }
        }

        if(maxHeap.size() - minHeap.size() == 2) {
          minHeap.add(maxHeap.remove());
        }
        else if(minHeap.size() - maxHeap.size() == 2){
          maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        int n = maxHeap.size();
        int m = minHeap.size();

        if((n + m) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        if(n > m) return maxHeap.peek();
        else return minHeap.peek();
    }
}