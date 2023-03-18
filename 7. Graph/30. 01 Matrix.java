// https://leetcode.com/problems/01-matrix/

// TC - O(N * M)
// SC - O(N * M)

import java.util.*;

class Solution {
    
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    } 
    
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Pair> que = new ArrayDeque<>();
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                
                if(mat[i][j] == 0) {
                    que.add(new Pair(i, j));
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }
        

        
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        while(que.size() > 0) {
            
            Pair rem = que.remove();
            
            for(int i = 0; i < 4; i++) {
                int new_row = rem.row + dir[i][0];
                int new_col = rem.col + dir[i][1];
                
                if(new_row >= 0 && new_col >= 0 && new_row < mat.length && new_col < mat[0].length && mat[new_row][new_col] == -1) {
                    
                    mat[new_row][new_col] = mat[rem.row][rem.col] + 1;
                    que.add(new Pair(new_row, new_col));
                    
                    
                }
            }
        }
        
        return mat;
    }
}