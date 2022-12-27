// https://leetcode.com/problems/rotate-image/

// TC - O(n^2)
// SC - O(1)

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
    public void reverseRow(int[][] matrix) {
        for(int r = 0; r < matrix.length; r++) {
            int left = 0;
            int right = matrix.length - 1;

            while(left < right) {
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;

                left++;
                right--;
            }
        }
    }
}

/********* Transpose Function  **********/

public void transpose2(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < m; j++)  {
            swap(matrix, i, j);
        }
    }
}

public void swap(int[][] matrix, int i, int j) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[j][i];
    matrix[j][i] = temp;
}