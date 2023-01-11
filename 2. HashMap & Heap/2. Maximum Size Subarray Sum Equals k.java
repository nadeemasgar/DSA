// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum - k)) {
                int prevIdx = map.get(sum - k);
                int len = i - prevIdx;
                maxLen = Math.max(maxLen, len);
            }
            
            if(map.containsKey(sum) == false) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}