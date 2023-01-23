// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

// Given n as the length of s, a as the length of words, and b as the length of each word:
// TC - O(a + n * b)
// SC - O(a + b)

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int len = words[0].length(); // length of each word

        // Frequency map of words
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            int freq = map.getOrDefault(word, 0);
            map.put(word, freq + 1);
        }

        for(int i = 0; i <= s.length() - len * words.length; i++) {
            HashMap<String, Integer> copyMap = new HashMap<>(map);

            for(int j = 0; j < words.length; j++) {
                int index = i + j * len;
                String str = s.substring(index, index + len);

                if(copyMap.containsKey(str)) { // is in the remaining words
                    int count = copyMap.get(str);
                    if(count == 1) copyMap.remove(str);
                    else copyMap.put(str, count - 1);
                    if(copyMap.isEmpty()) { // matches
                        ans.add(i);
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }

        return ans;
    }
}