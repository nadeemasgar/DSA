// https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

class Solution {
    void segregate0and1(int[] nums, int n) {
       int i = 0, j = 0;
       
       while(j < n) {
           if(nums[j] == 1) {
               j++;
               
           }
           else {
               swap(nums, i, j);
               i++;
               j++;
           }
       }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
