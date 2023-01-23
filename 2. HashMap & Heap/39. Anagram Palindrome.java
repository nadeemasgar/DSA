// https://practice.geeksforgeeks.org/problems/anagram-palindrome4720/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution
{
    int isPossible (String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }
        
        int oddCount = 0;
        for(char key : map.keySet()) {
            int freq = map.get(key);
            if(freq % 2 == 1) {
                oddCount++;
            }
            
            if(oddCount > 1) return 0;
        }
        
        return 1;
    }
}