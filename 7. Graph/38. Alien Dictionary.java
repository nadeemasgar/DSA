// https://leetcode.com/problems/alien-dictionary/description/
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

// TC : O(N * L) 
// SC: O(C)

// If 'N' is the number of words in the input alien vocabulary/dictionary, 
// 'L' length of the max length word, and 'C' is the final number of unique characters

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        boolean flag = false;

        // Indegree Creation
        for(String st : words) {
            for(char ch : st.toCharArray()) {
                indegree.put(ch, 0);
            }
        }
        
        // Graph Creation
        for(int i = 0; i < words.length-1; i++) {
            String curr = words[i];
            String next = words[i+1];
            int len = Math.min(curr.length(), next.length());
            
            for(int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                
                if(ch1 != ch2) {
                    
                    if(map.containsKey(ch1) == true) { // In Map ch1 is present which means existed HashSet is there
                        HashSet<Character> set = map.get(ch1);
                        
                        if(set.contains(ch2) == false) {
                            set.add(ch2);
                            indegree.put(ch2, indegree.get(ch2)+1);
                            map.put(ch1, set);
                        }
                    }
                    else { // In Map ch1 is not present which means we have to create a hashSet
                        HashSet<Character> set = new HashSet<>();
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2)+1);
                        map.put(ch1, set);
                    }
                    flag = true;
                    break;
                }
            }
            
            if(flag == false && curr.length() > next.length()) return "";
        }

        return topoSort(map, indegree);
    }


    public String topoSort(HashMap<Character, HashSet<Character>> map, HashMap<Character, Integer> indegree) {
        Queue<Character> que = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        
        for(char ch : indegree.keySet()) {
            if(indegree.get(ch) == 0) {
                que.add(ch);
            }
        }
        
        int count = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                char rem = que.remove();
                ans.append(rem);
                count++;
                
                if(map.containsKey(rem) == true) {
                    HashSet<Character> nbrs = map.get(rem);
                    
                    for(char nbr : nbrs) {
                        indegree.put(nbr, indegree.get(nbr)-1);
                        
                        if(indegree.get(nbr) == 0) {
                            que.add(nbr);
                        }
                    }
                }
                
            }
        }
        
        if(count == indegree.size()) {
            return ans.toString();
        }
        else {
            return "";
        }
    }
}