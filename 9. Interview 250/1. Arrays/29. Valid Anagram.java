// https://leetcode.com/problems/valid-anagram/

// https://leetcode.com/problems/valid-anagram/description/

// TC - O(N + M)
// SC - O(N + M)

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch : s.toCharArray()) {
            int freq = map1.getOrDefault(ch, 0);
            map1.put(ch, freq + 1);
        }
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch : t.toCharArray()) {
            int freq = map2.getOrDefault(ch, 0);
            map2.put(ch, freq + 1);
        }
        
        return map1.equals(map2);
    }
}