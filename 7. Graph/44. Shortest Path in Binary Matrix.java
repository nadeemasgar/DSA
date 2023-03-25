// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length, shortestPath = 1;
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        
        que.addLast(0);
        
        while(que.size() != 0) {
            int size = que.size();
            
            while(size-- != 0) {
                int idx = que.removeFirst();
                
                int i = idx / m , j = idx % m;
                
                if(i == n - 1 && j == m - 1) {
                    return shortestPath;
                }
                
                for(int d = 0; d < 8; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        que.add(nr * m + nc);
                    }
                }
            }
            
            shortestPath++;
        }
        
        return -1;
    }
}