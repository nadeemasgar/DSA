// https://leetcode.com/problems/best-meeting-point/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

// BFS

// TC - O((m^2)(n^2)) => For each point, BFS takes at most n * m step to reach all points
// SC - O(mn)

class Solution {
    int leastDist = Integer.MAX_VALUE;
    public int minTotalDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    leastDist = Integer.MAX_VALUE;
                    BFS(i, j, dist, 0);
                } 
            }
        }
        
        // last iteration will have the minimum total distance from all home
        return leastDist;
    }

    // Run BFS for each home and calclate their shortest distance in grid
    public void BFS(int i, int j, int[][] dist, int level) {
        int n = dist.length, m = dist[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{i, j});
        vis[i][j] = true;

        while(que.size() > 0) {
            int size = que.size();
            level++;

            while(size-- > 0) {
                int[] rem = que.remove();
                int row = rem[0];
                int col = rem[1];

                for(int[] dir : dirs) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol]) {
                        que.add(new int[]{nrow, ncol});
                        vis[nrow][ncol] = true;
                        dist[nrow][ncol] += level;
                        leastDist = Math.min(leastDist, dist[nrow][ncol]);
                    }
                } 
            }
        }
    }
}

// TC - O(mn * logmn)
// SC - O(mn)

class Solution2 {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        Collections.sort(cols);

        int midIdx = rows.size() / 2;
        int midIdy = cols.size() / 2;

        int midX = rows.get(midIdx);
        int midY = cols.get(midIdy);

        return midDistance(rows, midX) + midDistance(cols, midY);
    }

    public int midDistance(ArrayList<Integer> points, int origin) {
        int distance = 0;
        for(Integer point: points) {
            distance += Math.abs(point - origin);
        }

        return distance;
    } 
}

// TC - O(m * n)
// SC - O(m * n)

class Solution3 {
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