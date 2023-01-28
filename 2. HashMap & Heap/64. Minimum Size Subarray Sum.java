// https://leetcode.com/problems/minimum-size-subarray-sum/

// TC - O(n)
// SC - O(n)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE, sum = 0;

        while(end < nums.length) {
            if(sum < target) sum += nums[end];
            end++;

            while(sum >= target){
                minLen = Math.min(minLen, end - start); 
                sum -= nums[start];
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}