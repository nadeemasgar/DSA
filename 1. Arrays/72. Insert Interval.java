// https://leetcode.com/problems/insert-interval/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals) {
            if(interval[1] < newInterval[0]) { // newInterval is on right
                result.add(interval);
            }
            else if(newInterval[1] < interval[0]) { // newInterval is on left
                result.add(newInterval);
                newInterval = interval;
            }
            else { // merging
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}