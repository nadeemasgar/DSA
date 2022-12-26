// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.*;

// TC - O(N)
// SC - O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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

        ArrayList<Integer> list = new ArrayList<>();

        // Search for first missing number
        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] != idx + 1) {
                list.add(idx + 1);
            }
        }

        return list;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}