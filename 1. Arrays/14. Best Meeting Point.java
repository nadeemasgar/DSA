// https://leetcode.com/problems/best-meeting-point/

import java.util.ArrayList;

class Solution {
    public int minTotalDistance(int[][] grid) {
        // 1. Get x-coordinate -> row wise
        ArrayList<Integer> xcord = new ArrayList<>();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    xcord.add(r);
                }
            }
        }
        
        // 2. Get y-coordinate -> column wise
        ArrayList<Integer> ycord = new ArrayList<>();
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1) {
                    ycord.add(c);
                }
            }
        }
        
        // 3. Get Mid -> best meeting point
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        
        // 4. Calculate distance -> min distance(because of median)
        int dist = 0;
        for(int xval : xcord) {
            dist += Math.abs(x - xval);
        }
        
        for(int yval : ycord) {
            dist += Math.abs(y - yval);
        }
        
        return dist;
    }
}