// https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/description/

// TC - O(r * c * log(r*c))
// SC - O(r * c)

import java.util.*;

class Solution {
    public int matrixMedian(int[][] grid) {
        int rowSize = grid.length, columnSize = grid[0].length;
        int indx = 0;
        int[] arr = new int[rowSize * columnSize];
        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < columnSize; j++) {
                arr[indx] = grid[i][j];
                indx++;
            }
        }
        Arrays.sort(arr);
        int medianIndx = indx / 2;
        return arr[medianIndx];
    }
}

// TC -  (log(max - min) * r * log(c))
// SC - O(1)