// https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
// https://leetcode.com/problems/contiguous-array/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {

    int maxLen(int[] nums, int N)
    {
        // Changing 0s to -1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum) == false) {
                map.put(sum, i);
            }
            else {
                int prevIdx = map.get(sum);
                int len = i - prevIdx;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}
