// https://leetcode.com/problems/merge-intervals/description/

import java.util.*;

// TC - O(N)
// SC - O(1)

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> {  // Sorting by start time
            return a[0] - b[0];
        });

        for(int[] interval: intervals) {
            if(res.size() == 0) {
                res.add(interval);
            }
            else {
                int[] prev = res.get(res.size() - 1);
                int end = prev[1]; // end time of prev intervals
                
                if(interval[0] <= end) { // overlapping
                    prev[1] = Math.max(end, interval[1]);
                }
                else { // not overlapping
                    res.add(interval);
                }
            }
        }

        return res.toArray(new int[0][]);
    }
}