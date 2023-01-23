// https://leetcode.com/problems/longest-repeating-character-replacement/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        // maxCount = possible char with highest freq in the range        
		int start = 0, end = 0;
        int maxCount = 0, maxLength = 0; 
        
        HashMap<Character, Integer> map = new HashMap<>();
    
        while(end <s.length()) {
            char ch = s.charAt(end);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);

            maxCount = Math.max(maxCount, map.get(ch));
            end++;
            
            while(end - start - maxCount > k) {
                char removeChar = s.charAt(start);
                map.put(removeChar, map.get(removeChar) - 1);

                maxCount = Math.max(maxCount, map.get(removeChar));
                start++;
            }

            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}