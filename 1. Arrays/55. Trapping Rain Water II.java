// https://leetcode.com/problems/trapping-rain-water-ii/description/

// TC - O(n * m) * log(n * m)
// SC - O(n * m)

import java.util.PriorityQueue;

class Solution {

    public class Pair implements Comparable<Pair> {
        int row;
        int col;
        int height;

        Pair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Pair o) {
            return this.height - o.height;
        }
    }

    public int trapRainWater(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.add(new Pair(i, j, heights[i][j]));
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int water = 0;

        while(pq.size() > 0) {
            Pair rem = pq.remove();

            for(int[] dir : dirs) {
                int row = rem.row + dir[0];
                int col = rem.col + dir[1];

                if(row >= 0 && col >= 0 && row < n && col < m && vis[row][col] == false) {
                    water += Math.max(0, rem.height - heights[row][col]);

                    if(heights[row][col] >= rem.height) {
                        pq.add(new Pair(row, col, heights[row][col]));
                    }
                    else {
                        pq.add(new Pair(row, col, rem.height));
                    }

                    vis[row][col] = true;
                }
            }
        }

        return water;
    }
}