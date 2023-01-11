// https://practice.geeksforgeeks.org/problems/equal-0-1-and-23208/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    {
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        
        int zeros = 0, ones = 0, twos = 0;
        int count = 0;
        
        for(int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
    
            if(num == '0') zeros++;
            else if(num == '1') ones++;
            else if(num == '2') twos++;
            
            int diff1 = zeros - ones;
            int diff2 = ones - twos;
            String s = diff1 + "#" + diff2;
            
            count += map.getOrDefault(s, 0);
            
            if(map.containsKey(s)) {
                int freq = map.get(s);
                map.put(s, freq + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        
        return count;
        
    }
} 