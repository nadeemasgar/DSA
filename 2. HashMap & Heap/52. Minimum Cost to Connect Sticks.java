// https://leetcode.com/problems/minimum-cost-to-connect-sticks/description/

// TC - O(N * log N) 
// SC - O(N)

import java.util.*;

class Solution {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        // add all sticks to the min heap.
        for (int stick : sticks) {
            pq.add(stick);
        }
 
        // combine two of the smallest sticks until we are left with just one.
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            
            int cost = stick1 + stick2;
            totalCost += cost;
            
            pq.add(stick1 + stick2);
        }
 
        return totalCost;
    }
}