// https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0; 
        int j = 0;
        
        while(j < A.length) {
            
            if(A[j] % 2 == 0) { // Even Element
                swap(A, i , j);
                i++;
                j++;
            }
            else {  // Odd Element
                j++;
            }
        }
        
        return A;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}