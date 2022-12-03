// https://leetcode.com/problems/max-chunks-to-make-sorted/

class Solution {
    public int maxChunksToSorted(int[] nums) {
        int max = 0, count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            
            if(i == max)
                count++;
        }
        
        return count;
    }
}