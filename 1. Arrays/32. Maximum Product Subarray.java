// https://leetcode.com/problems/maximum-product-subarray/description/

// Time - O(n^2)

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int accu = 1;
            for (int j = i; j < nums.length; j++) {
                accu *= nums[j];
                result = Math.max(result, accu);
            }
        }

        return result;
    }
}

// Time - O(n)

class Solution2 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
       
        // Maximum product from starting
        int cprod = 1;
        for(int i = 0; i < nums.length; i++) {
            cprod *= nums[i];
            ans = Math.max(ans, cprod);
            if(cprod == 0) {
                cprod = 1;
            }
        }

        // Maximum product from ending
        cprod = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            cprod *= nums[i];
            ans = Math.max(ans, cprod);
            if(cprod == 0) {
                cprod = 1;
            }
        }

        return ans;
    }
}

// Time - O(n)

class Solution3 {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int curr_min = nums[0];
        int curr_max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr_max_prev = curr_max;
            curr_max = Math.max(nums[i], Math.max(curr_max * nums[i], curr_min * nums[i]));
            curr_min = Math.min(nums[i], Math.min(curr_max_prev * nums[i], curr_min * nums[i]));

            result = Math.max(result, curr_max);
        }

        return result;
    }
}