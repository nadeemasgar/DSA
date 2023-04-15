// https://leetcode.com/problems/find-the-duplicate-number/description/

// TC - O(N)
// SC - O(1)

import java.util.*;

class Solution1 {
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


class Solution2 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }

        return -1;
    }
}

class Solution3 {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}