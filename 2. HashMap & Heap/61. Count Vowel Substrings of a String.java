// https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        return countSubstring(word, 5) - countSubstring(word, 4);
    }
    
    public int countSubstring(String s, int target) {
        int start = 0, end = 0,  res = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(end < s.length()) {
            if (!isVowel(s.charAt(end))) {
                start = end + 1;
                map.clear();
            } else {
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
                while (map.size() > target) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    map.remove(s.charAt(start), 0);
                    start++;
                }
                res += end - start + 1;
            }
            end++;      
        }
        
        return res;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
    }
}