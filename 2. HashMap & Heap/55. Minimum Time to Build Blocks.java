// https://leetcode.com/problems/minimum-time-to-build-blocks/

import java.util.*;

// TC - O(n * log n)
// SC - O(n)

class Solution {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int b : blocks) pq.add(b);
        while (pq.size() > 1) {
            int x = pq.poll(), y = pq.poll();
            pq.add(y + split);
        }
        return pq.poll();
    }
}