// https://leetcode.com/problems/non-overlapping-intervals/description/

// TC - O(n*logn)
// SC - O(1)

import java.util.Arrays;


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int n = intervals.length;
        int prevEnd = intervals[0][1];  
        
        for(int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start >= prevEnd) { // Non-Overlapping
                prevEnd = end;
            }
            else { // Overlapping
                count += 1;
                prevEnd = Math.min(end, prevEnd);
            }
        }

        return count; 
    }
}

class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int n = intervals.length;
        int left = 0;   // left interval
        int right = 1;  // right interval

        while(right < n) {
            
            if(intervals[left][1] <= intervals[right][0]) { // Non-Overlapping case
                left = right;
                right += 1;
            } 
            else if(intervals[left][1] <= intervals[right][1]) { // Overlapping case-1 (Remove right interval)
                 count += 1; // Delete right
                 right += 1;
            }
            else if(intervals[left][1] > intervals[right][1]) { // Overlapping case-2 (Remove left interval)
                count += 1;
                left = right;
                right += 1;
            }
        } 

        return count; 
    }
}