// https://leetcode.com/problems/maximum-subarray/

// Naive Approach

// TC - O(N^2)
// SC - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}


// Kadane's Algo

// TC - O(N)
// SC - O(1)

class Solution2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;

        for(int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);

            if(sum < 0) {
                sum = 0;
            } 
        }

        return ans;
    }
}


