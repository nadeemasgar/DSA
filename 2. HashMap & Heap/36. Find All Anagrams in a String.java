// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : p.toCharArray()) {
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }

        int start = 0, end = 0;
        int counter = map.size();

        while(end < s.length()) {
            char ch = s.charAt(end);
            if( map.containsKey(ch) ){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) counter--;
            }
            end++;

            while(counter == 0) {
                if(end - start == p.length()) {
                    ans.add(start);
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

        return ans;
    }
}