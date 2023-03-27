// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

// TC - O(n^3)
// SC - O(n^2)

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
    /* 
        // how to detect negative cycle
        for(int i = 0; i < n; i++) {
            if(matrix[i][j] < 0) {
                // it contains negative cycle
            }
        }
    */
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}