// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        return countSubstringKDistinct(s, 3) - countSubstringKDistinct(s, 2);
    }

    public int countSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, count = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            while(counter > k){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            count += end-start; // Number of subarray ending at end
        }
        
        return count;
    }
}


// TC - O(n)
// SC - O(n)

class Solution2 {
    public int numberOfSubstrings(String s) {
        int start = 0;
        int end = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        for (end = 0; end < n; end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() == 3) {
                char chToRemove = s.charAt(start);
                count += (n - end);  // adding current and obviously possible remaining susbstrings till end of main string
                
                map.put(chToRemove, map.get(chToRemove)  - 1);
                if (map.get(chToRemove) == 0) {
                    map.remove(chToRemove);
                }
                start++;
            }
        }
        
        return count;
    }
}