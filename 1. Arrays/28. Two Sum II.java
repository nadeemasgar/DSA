// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        while(i < j) {
            int ele1 = nums[i], ele2 = nums[j];
            if(ele1 + ele2 == target) {
                return new int[]{i + 1, j + 1};
            }
            else if(ele1 + ele2 > target) {
                j--;
            }
            else {
                i++;
            }
        }

        return new int[2];
    }
}