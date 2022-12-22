// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

// Using Median

// TC - O(N)
// SC - O(1)

import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        // Sort the array
        Arrays.sort(nums);

        // Find the median
        int median = 0;
        if(n % 2 == 0) { 
            median = (nums[n / 2] + nums[(n / 2) - 1]) / 2;
        }
        else {
            median = nums[n / 2]; 
        }
    
        int steps = 0;
        for(int num : nums) {
            steps += Math.abs(num - median);
        }

        return steps;
    }
}


// Using Two Pointer

// TC - O(N)
// SC - O(1)

class Solution2 {
    public int minMoves2(int[] nums) {
        int l = 0, r = nums.length - 1, sum = 0;
        Arrays.sort(nums);
        while (l < r) {
            sum += nums[r] - nums[l];
            l++;
            r--;
        }
        return sum;
    }
}
