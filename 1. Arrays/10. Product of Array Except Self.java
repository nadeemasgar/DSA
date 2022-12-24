// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] suffixProduct = new int[n + 1];
        suffixProduct[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            int prod = nums[i] * suffixProduct[i + 1];
            suffixProduct[i] = prod;
        }

        int[] ans = new int[n];
        int currProd = 1; // Product from left on the go

        for(int i = 0; i < n; i++) {
            ans[i] = currProd * suffixProduct[i + 1];
            currProd *= nums[i];
        }

        return ans;
    }
}