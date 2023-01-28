// https://leetcode.com/problems/subarray-product-less-than-k/description/

// TC - O(n)
// SC - O(n)

class Solution {
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1) return 0;
        int ans = 0;
        int product = 1;
        int left = 0;
        
        for(int right = 0; right < n; right++){
            product *= nums[right];
            while(product >= k){ // Decreasing the window
                product /= nums[left++];
            }
            ans += right-left+1;
        }
        return ans;
    }
}