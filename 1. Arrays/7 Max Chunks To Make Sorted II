// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

class Solution {
    public int maxChunksToSorted(int[] nums) {
        int n = nums.length, min = (int)1e9;
        int[] rightMin = new int[n + 1]; // 1. Generate Right Min
        
        rightMin[n] = (int)1e9;
        
        for(int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            rightMin[i] = min;
        }
        
        int max = 0, count = 0;
        
        for(int i = 0; i < n; i++) { // 2. Iterate over array and manage left max as well as count chunks
            max = Math.max(max, nums[i]);
            
            if(max <= rightMin[i+1]) 
                count++;
        }
        
        return count;
    }
}