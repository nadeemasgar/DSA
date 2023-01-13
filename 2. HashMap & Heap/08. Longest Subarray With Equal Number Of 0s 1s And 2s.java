// Longest Subarray With Equal Number Of 0s 1s And 2s
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public static int subarrayLength(int[] nums) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        
        int zeros = 0, ones = 0, twos = 0;
        int maxLen = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else if(nums[i] == 2) twos++;
            
            int diff1 = ones - zeros;
            int diff2 = twos - ones;
            
            String s = diff1 + "#" + diff2;
            
            if(map.containsKey(s) == false) {
                map.put(s, i);
            }
            else {
                int prevIdx = map.get(s);
                int len = i - prevIdx;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}