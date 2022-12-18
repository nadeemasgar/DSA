// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

// TC - O(N)
// SC - O(1)

class Solution {
    // Function for finding maximum and value pair
    public static int minSwap (int nums[], int n, int k) {
        int windowSize = 0;
        // get the window size
        for(int num : nums) {
            if(num <= k) {
                windowSize++;
            }
        }
        
        // First window
        int badEle = 0;
        for(int i = 0; i < windowSize; i++) {
            if(nums[i] > k) {
                badEle++;
            }
        }
        
        int i = 0, j = windowSize, result = badEle;
        while(j < n) {
            int newEle = nums[j];
            int leftEle = nums[i];
            
            if(newEle > k) {
                badEle++;
            }
            
            if(leftEle > k) {
                badEle--;
            }
            
            result = Math.min(result, badEle);
            j++;
            i++;
        }
        
        return result;
    }
}