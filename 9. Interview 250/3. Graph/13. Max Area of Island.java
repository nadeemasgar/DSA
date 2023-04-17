// https://leetcode.com/problems/max-area-of-island/description/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int recAns = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, recAns);
                }
            }
        }
        
        return maxArea;
    }
    
    int[][] direction = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
    
    public int dfs(int[][] grid, int i, int j) {
        
        
        grid[i][j] = 0;
        
        int count = 0;
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = i + direction[dir][0];
            int nc = j + direction[dir][1];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                count += dfs(grid, nr, nc);
            }
        }
        
        return count + 1;
    }
}