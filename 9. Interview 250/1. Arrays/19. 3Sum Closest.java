// https://leetcode.com/problems/3sum-closest/description/

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while(low < high) {
                int currentSum = nums[i] + nums[low] + nums[high];
                if(currentSum > target) {
                    high--;
                }
                else {
                    low++;
                }

                if(Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }

        return result;
    }
}