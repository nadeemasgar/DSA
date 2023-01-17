// https://leetcode.com/problems/island-perimeter/description/

// TC - O(n*m)
// SC - O(1)

class Solution {
    
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int islandPerimeter(int[][] grid) {
        int onesCount = 0, nbrsCount = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 1) {
                    onesCount++;
                    
                    for(int d = 0; d < dir.length; d++) {
                        int nr = i + dir[d][0];
                        int nc = j + dir[d][1];

                        if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) 
                            nbrsCount++;
                    }
                }
            }
        }
        
        return ((4 * onesCount) - nbrsCount);
    }
}