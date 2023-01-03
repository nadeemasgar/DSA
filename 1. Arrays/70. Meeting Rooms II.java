// https://leetcode.com/problems/meeting-rooms-ii/description/

import java.util.*;

// TC - O(N)
// SC - O(N)

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        // only end time is sufficient
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 

        for(int[] interval : intervals) {
            if(pq.size() == 0) {
                pq.add(interval[1]); // push the end time
            }
            else {
                // end time of prev <= start time of curr
                if(pq.peek() <= interval[0]) { 
                    pq.remove();
                    pq.add(interval[1]);
                }
                else {
                    pq.add(interval[1]);
                }
            }
        }

        return pq.size();
    }
}