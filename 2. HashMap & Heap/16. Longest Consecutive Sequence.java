// https://leetcode.com/problems/longest-consecutive-sequence/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int maxLen = 0;

        for(int num : nums) {
            if(!set.contains(num - 1)) { // num is starting of sequence
                int currentLength = 1;
                while(set.contains(++num)) {
                    currentLength++;
                }

                maxLen = Math.max(maxLen, currentLength);
            }
        }

        return maxLen;
    }
}