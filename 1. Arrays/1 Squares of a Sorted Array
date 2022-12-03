// https://leetcode.com/problems/squares-of-a-sorted-array/
// Time - O(n)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length, i = 0, j = length - 1;
        int[] ans = new int[length];
        int k = length - 1;
        
        while(i <= j) {
            int ele1 = nums[i] * nums[i];
            int ele2 = nums[j] * nums[j];
            
            if(ele1 > ele2) {
                ans[k] =  ele1;
                i++;
            }
            else {
                ans[k] = ele2;
                j--;
            }
            
            k--;
        }
        
        return ans;
    }
}