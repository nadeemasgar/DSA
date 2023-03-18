// https://leetcode.com/problems/number-of-enclaves/description/

// TC - O(N * M)
// SC - O(N * M)

class Solution {
    public int numEnclaves(int[][] grid) {
        
        // top boundary
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[0][j] == 1) {
                dfs(0, j, grid);
            }
        }
        
        // bottom boundary
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[grid.length - 1][j] == 1) {
                dfs(grid.length - 1, j, grid);
            }
        }
        
        //left boundary
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
        }
        
        //right boundary
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][grid[0].length - 1] == 1) {
                dfs(i, grid[0].length - 1, grid);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }

    int[][] direction = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
    
    public void dfs(int i, int j, int[][] grid) { 
        
        grid[i][j] = 0;
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = i + direction[dir][0];
            int nc = j + direction[dir][1];
            
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1)
                dfs(nr, nc, grid);
        }
    }
}