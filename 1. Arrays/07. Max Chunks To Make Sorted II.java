// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

import java.util.*;

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


// TC - O(n * log n)
// SC - O(1)

class Solution2 {
    public int maxChunksToSorted(int[] arr) {
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    int res = 0, sum1 = 0, sum2 = 0;
    for (int i = 0; i < arr.length; i++) {
        sum1 += arr[i];
        sum2 += sorted[i];
        if (sum1 == sum2) res += 1;
    }
    return res;
}
}