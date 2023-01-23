// https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch2 : s2.toCharArray()) {
            if(map.getOrDefault(ch2, 0) > 0) {
                map.put(ch2, map.get(ch2) - 1);
            }
        }
        
        int count = 0;
        for(char key: map.keySet()) {
            count += map.get(key);
        }
        
        return count <= k ? true : false;
    }
}