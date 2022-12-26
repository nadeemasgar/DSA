// https://leetcode.com/problems/set-mismatch/

// TC - O(N)
// SC - O(1)

class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }

        // Search for first missing number
        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] != idx + 1) {
                return new int[]{nums[idx], idx + 1};
            }
        }

        return new int[2];
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}