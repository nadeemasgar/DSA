// https://leetcode.com/problems/reorganize-string/description/
// https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1

// TC - O(N log(N))
// SC - O(N)

import java.util.*;

class Solution {
    
    public static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    
	public String reorganizeString(String s) {
        //create a hashmap 
	    HashMap<Character,Integer> map = new HashMap<>();
	    for(int i = 0; i < s.length(); i++){
	        char ch = s.charAt(i);
	        map.put(ch, map.getOrDefault(ch, 0) + 1);
	    }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.freq - a.freq); // MAX_HEAP
        for(char ch: map.keySet()){
	        pq.add(new Pair(ch, map.get(ch)));
	    }

        StringBuilder ans = new StringBuilder();
        Pair block = pq.remove();
        ans.append(block.ch);
        block.freq--;

        while(pq.size() > 0) {
            Pair temp = pq.remove();
            ans.append(temp.ch);
            temp.freq--;
            if(block.freq > 0) {
                pq.add(block);
            }
            block = temp;
        }

        if(block.freq > 0) return "";

        return ans.toString();
    }
}