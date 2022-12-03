// https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class Solution {
    public int dominantIndex(int[] nums) {
        int max1 = 0, max2 = 0;
        int idx = -1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                idx = i;
            }
            else if(nums[i] > max2){
                max2 = nums[i];
            }
        }
        
        return max1 >= max2 * 2 ? idx : -1;
    }
}