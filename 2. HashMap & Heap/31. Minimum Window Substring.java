// https://leetcode.com/problems/minimum-window-substring/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = map.size();

        while(end < s.length()) {
            char ch = s.charAt(end);
            if( map.containsKey(ch) ){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) counter--;
            }
            end++;

            while(counter == 0) {
                if(minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                char tempc = s.charAt(start);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }

                start++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}