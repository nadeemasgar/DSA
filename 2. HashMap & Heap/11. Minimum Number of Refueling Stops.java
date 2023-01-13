// https://leetcode.com/problems/minimum-number-of-refueling-stops/description/

// TC - O(N log N)
// SC - O(N)

import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int max_you_can_reach = startFuel;
        int count = 0;
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(max_you_can_reach < target) {

            while(idx < stations.length && stations[idx][0] <= max_you_can_reach) {
                pq.add(stations[idx][1]); // storing fuel provided by gas station in our priority queue
                idx++;
            }

            if(pq.isEmpty()) return -1;

            max_you_can_reach += pq.remove(); //max fuel
            count++;
        }

        return count;
    }
}