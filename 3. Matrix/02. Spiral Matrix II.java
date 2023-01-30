// https://leetcode.com/problems/spiral-matrix-ii/description/

// TC - O(m * n)
// SC - O(1)

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int row = ans.length;
        int col = ans[0].length;
        int count = 1;
        int total = row * col;

        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row - 1;
        int endingCol = col - 1;

        while(count <= total) {
            // For starting row
            for(int i = startingCol; count <= total && i <= endingCol; i++) {
                ans[startingRow][i] = count;
                count++;
            }
            startingRow++;

            // For ending col
            for(int i=startingRow; count <= total && i <= endingRow; i++) {
                ans[i][endingCol] = count;
                count++;
            }
            endingCol--;

            // For ending row
            for(int i=endingCol; count <= total && i >= startingCol; i--) {
                ans[endingRow][i] = count;
                count++;
            }
            endingRow--;

            // For starting col
            for(int i=endingRow; count <= total && i >= startingRow; i--) {
                ans[i][startingCol] = count;
                count++;
            }
            startingCol++;
        }

        return ans;
    }
}