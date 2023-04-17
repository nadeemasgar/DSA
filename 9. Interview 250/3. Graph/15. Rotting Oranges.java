// https://leetcode.com/problems/rotting-oranges/description/

import java.util.*;

class Solution {
    class Pair {
        int i;
        int j;
        
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        
        LinkedList<Pair> que = new LinkedList<>();
        int fresh = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2)
                    que.addLast(new Pair(i, j));
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        
        if(fresh == 0) return 0;
        
        int time = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair rem = que.removeFirst();
                int i = rem.i, j = rem.j;
                if(time != 0 && grid[i][j] == 2) {
                    fresh--;
                }
          
                if(fresh == 0) return time;
                
                for(int d = 0; d < 4; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        que.addLast(new Pair(nr, nc));
                    }
                }
            }
            
            time++;
        }
        
        return -1;
    }
}