// https://leetcode.com/problems/rearrange-string-k-distance-apart/description/

// TC - O(N log(N))
// SC - O(N)

import java.util.*;

class Solution {
    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        Queue<Character> que = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        while(!pq.isEmpty()) {
            Character ch = pq.remove();
            map.put(ch, map.get(ch) - 1);
            ans.append(ch);
            que.add(ch);

            // Characters are added back in the heap in the order they were removed
			// Whenever all the instances of a particular char is exhausted, then the heap size is reduced as
            // it is not added back in the heap
            if(que.size() >= k) {
                char c = que.remove();
                if(map.get(c) > 0) {
                    pq.add(c);
                }
            }
        }

        return ans.length() == s.length() ? ans.toString() : ""; 
    }
}