// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<long[]> que = new ArrayDeque<>(); // [index, sum]
        long sum = 0;
        long shortest = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum >= k) {
                shortest = Math.min(shortest, i + 1); // sum from start to i-th index
            }

            // Reduce window size to find minimum window with sum >= k
            long[] curr = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            while(!que.isEmpty() && sum - que.peek()[1] >= k) {
                curr = que.pollFirst();
            }

            // calculate the new shortest (if possible)
            if(curr[1] != Integer.MIN_VALUE) {
                shortest = Math.min(shortest, i - curr[0]);
            }

            // Maintain monotonically non-decreasing order of queue
            while(!que.isEmpty() && sum <= que.peekLast()[1]) {
                que.pollLast();
            }

            que.offerLast(new long[]{i, sum}); // Push i-th sum
        }

        return shortest == Integer.MAX_VALUE ? -1 : (int)shortest; 
    }
}