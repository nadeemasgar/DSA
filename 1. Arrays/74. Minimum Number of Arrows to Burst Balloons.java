// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

// TC - O(n)
// SC - O(1)

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
         Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
        int n = points.length;

        int count = 1;
        int prevEnd = points[0][1];
        
        for(int i = 1; i < n; i++) {
            int start = points[i][0];
            int end = points[i][1];

            if(prevEnd < start) {
                count++;
                prevEnd = end;
            }
        }

        return count;
    }
}