// https://leetcode.com/problems/line-reflection/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public boolean isReflected(int[][] points) {
      HashMap<Long, Long> map = new HashMap<>();
      long xmin = Integer.MAX_VALUE;
      long xmax = Integer.MIN_VALUE;

      for(int[] point : points) {
        long x = point[0];
        long y = point[1];

        xmin = Math.min(xmin, x);
        xmax = Math.max(xmax, x);

        long hash = x * 100000000 + y;
        map.put(hash, 1L);
      }

      long mirror = xmin + xmax;

      for(int[] point : points) {
        int x = point[0];
        int y = point[1];

        long ximg = mirror - x;
        long yimg = y;

        long imgHash = ximg * 100000000 + yimg;

        if(map.containsKey(imgHash) == false) {
          return false;
        }
      }

      return true;
    }
}