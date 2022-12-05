// https://leetcode.com/problems/maximum-subarray/
// Kadane's Algo

class Solution {
    public int maxSubArray(int[] nums) {
        int osum = nums[0], csum = 0;
        
        for(int num : nums) {  
            if(csum < 0) {
                csum = 0;
            }

            csum += num;
            osum = Math.max(osum, csum);
        }
        
        return osum;
    }
}