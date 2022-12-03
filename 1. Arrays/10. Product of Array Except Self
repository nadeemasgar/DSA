// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, mul = 1;
        int[] leftProduct = new int[n];
        
        for(int i = 0; i < nums.length; i++) {
            int res = mul * nums[i];
            leftProduct[i] = res;
            mul = res;
        }
        
        mul = 1;
        
        for(int i = n - 1; i >= 0; i--) {
            int left = i-1 >= 0 ? leftProduct[i-1] : 1;
            int prod = left * mul;
            mul *= nums[i];
            leftProduct[i] = prod;
        }
        
        return leftProduct;
    }
}