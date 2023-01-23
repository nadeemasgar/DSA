// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0, maxLen = 0;
        int counter = 0;

        while(end < s.length()) {
            char ch = s.charAt(end);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);

            if(map.get(ch) > 1) counter++;
            end++;

            while(counter > 0) {
                char ch1 = s.charAt(start);

                if (map.get(ch1) > 1) counter--;
                map.put(ch1, map.get(ch1) - 1);

                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}