// https://leetcode.com/problems/find-the-duplicate-number/description/

// TC - O(N)
// SC - O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0; 

        while(i < nums.length) {
            if(nums[i] != i + 1) {
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]) {
                    swap(nums, i, correct);
                }
                else {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }

        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}