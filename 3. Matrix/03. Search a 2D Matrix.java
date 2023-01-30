// https://leetcode.com/problems/search-a-2d-matrix/description/

// TC - O(log(m * n))
// SC - O(1)

class Solution {
    public boolean searchMatrix(int[][] arr, int data) {
        int rowIdx = binarySearchRowSelect(arr, data);
        if(rowIdx == -1 || rowIdx == arr.length) {
            return false;
        }
        boolean isPresent = BinarySearch(arr, rowIdx, data);
        return isPresent;
    }
    
    public int binarySearchRowSelect(int[][] arr, int data) {
        int si = 0, ei = arr.length - 1;
        int col = arr[0].length - 1;
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            if(arr[mid][col] == data)
                return mid;
            else if(arr[mid][col] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        } 
        
        return si;
    }
    
    public boolean BinarySearch(int[][] arr, int idx, int data) {
        int si = 0, ei = arr[0].length - 1;
        int row = idx;
        
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            if(arr[row][mid] == data)
                return true;
            else if(arr[row][mid] < data) 
                si = mid + 1;
            else 
                ei = mid - 1;
        } 
        
        return false;
    }
}

// Treating 2-D Array as a 1-D Array

class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, si = 0, ei = n * m - 1;
        while(si <= ei) {
            int mid = (si + ei) / 2;
            int r = mid / m, c = mid % m;
            if(matrix[r][c] == target) {
                return true;
            }
            else if(matrix[r][c] < target) {
                si = mid + 1;
            }
            else {
                ei = mid - 1;
            }
        }
        
        return false;
    }
}