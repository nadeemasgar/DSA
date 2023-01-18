// https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        HashMap<String, Integer> xymap = new HashMap<>();
        
        int sum = 0;
        for(int i = 0; i < X.length; i++) {
            int x = X[i];
            int y = Y[i];
            
            String xy = "" + x + "*" + y;
            
            int xfre = xmap.getOrDefault(x, 0);
            int yfre = ymap.getOrDefault(y, 0);
            int xyfre = xymap.getOrDefault(xy, 0);
            
            sum += xfre + yfre - 2 * xyfre;
            
            xmap.put(x, xfre + 1);
            ymap.put(y, yfre + 1);
            xymap.put(xy, xyfre + 1);
        }
        
        return sum;
    }
};