// https://leetcode.com/problems/number-of-islands/description/

// TC - O(M * N) 
// SC - O(M * N) 

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] direction = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
    
    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = i + direction[dir][0];
            int nc = j + direction[dir][1];
            
            dfs(grid, nr, nc);
        }
    }
}
