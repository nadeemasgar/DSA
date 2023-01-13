// https://leetcode.com/problems/subarray-sum-equals-k/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ps = 0; // prefix sum

        for(int i = 0; i < nums.length; i++) {
            ps += nums[i];
            count += map.getOrDefault(ps - k, 0);
            
            if(map.containsKey(ps)) {
                int freq = map.get(ps);
                map.put(ps, freq + 1);
            }
            else {
                map.put(ps, 1);
            }
        }

        return count;
    }
}