// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// TC - O(n * log n)
// SC - O(k)

import java.util.*;

class Solution {
    public int findKthLargest(int[] arr, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        int i = 0;

        while(k-- > 0) {
            pq.add(arr[i]);   
            i++;
        }

        while(i < arr.length) {
            int val = pq.peek();

            if(val < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }

            i++;
        }

        return pq.remove();
    }
}