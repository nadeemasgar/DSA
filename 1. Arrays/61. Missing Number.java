// https://leetcode.com/problems/missing-number/description/

// TC - O(N)
// SC - O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i < n) {
            int correct = nums[i];

            if(correct == n) {  // When nums[i] == n
                i++;
                continue;
            }
            else if(correct != i) { // When nums[i] is not at Correct Index
                swap(nums, i, correct);
            }
            else if(correct == i) { // When nums[i] is at correct Index
                i++;
            }
        }

        // Search for first missing number
        i = 0;
        while(i < n) {
            if(nums[i] != i) {
                return i;
            }
            i++;
        }

        return n;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}