// https://leetcode.com/problems/sliding-window-median/description/

// TC - O(n log k)
// SC - O(n)


import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                res[i-k] = medianFinder.findMedian();
                medianFinder.remove(nums[i-k]);
            }
            
            if (i < nums.length) 
                medianFinder.addNum(nums[i]);
        }
        
        return res;
    }
    
    class MedianFinder {

        private Queue<Integer> minHeap, maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>((a,b)->(a.compareTo(b)));
            maxHeap = new PriorityQueue<>((a,b)->(b.compareTo(a)));
        }

        public void addNum(int num) {
            minHeap.add(num);

            if (!maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }

            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
        }

        public double findMedian() {
            int size = minHeap.size() + maxHeap.size();
            if (size % 2 == 0) return ((long) minHeap.peek() + (long)maxHeap.peek()) / 2.0;
            else {
                if (minHeap.size() > maxHeap.size()) return minHeap.peek();
                return maxHeap.peek();
            }
        }
        
        public void remove(int n) {
            if (minHeap.contains(n)) minHeap.remove(n);
            else maxHeap.remove(n);
        }
    }
}