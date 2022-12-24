//https://leetcode.com/problems/subarray-product-less-than-k/description/

// Naive Approach

// TC - O(N^2)
// SC - O(1)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
             int prod = 1;
            for(int j = i; j < n; j++) {
                prod *= nums[j];
                if(prod >= k) break;
                count++;
            }
        }

        return count;
    }
}


// Sliding Window

// TC - O(N)
// SC - O(1)

class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0;
        int count = 0, prod = 1;

        for(i = 0; i < nums.length; i++) {
            prod *= nums[i];

            while(j < nums.length && prod >= k) { // Decreasing the window
                prod /= nums[j];
                j++;
            }

            if(prod < k) {
                count += i - j + 1;
            }
        }

        return count;
    }
}