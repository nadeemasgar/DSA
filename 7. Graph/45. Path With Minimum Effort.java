// https://leetcode.com/problems/path-with-minimum-effort/description/
// https://practice.geeksforgeeks.org/problems/path-with-minimum-effort/1

// TC - E log V => n * m * 4 * log(n * m)
// SC - N * N

import java.util.*;

class Pair {
    int row;
    int col;
    int distance;
    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        int n = heights.length; int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance - b.distance);
        pq.add(new Pair(0,0,0));
        
        int dist[][] = new int[n][m];
        dist[0][0] = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        
        while(pq.size() != 0) {
            Pair curr = pq.remove();
            int row = curr.row;
            int col = curr.col;
            int diff = curr.distance;
            
            if(row == n-1 && col == m-1)return diff;
            
            for(int i = 0; i < 4; i++ ) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nc >= 0 && nr >= 0 && nc < m && nr < n) {
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nr][nc]),diff);
                    if(effort < dist[nr][nc]) {
                        dist[nr][nc] = effort;
                        pq.add(new Pair(nr,nc,effort));
                    }
                }
            }
        }
        
        return 0;
    }
}
