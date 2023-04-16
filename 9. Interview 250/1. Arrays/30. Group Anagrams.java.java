// https://leetcode.com/problems/group-anagrams/description/

import java.util.*;

// TC - O(N * K) where N is the length of strs, and K is the maximum length of a string in strs
// SC - O(N * K)

// Pattern Matching

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String hash = getHash(str);

            if(map.containsKey(hash)) {
                List<String> list = map.get(hash);
                list.add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hash, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String getHash(String str) {
        int[] count = new int[26];
        for(char ch: str.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append('#');
        }
        
        return sb.toString();
    }
}

// Technique 2 - Group By Sorting

// TC - O(N*K * log(K))
// SC - O(N * K)

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c) ;
            String temp = String.valueOf(c);
            if(map.containsKey(temp))
            {
                List<String> list = map.get(temp);
                list.add(strs[i]);
                map.put(temp,list);
            }
            else
            { 
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }            
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
        // return new ArrayList<>(map.values());
    }
}