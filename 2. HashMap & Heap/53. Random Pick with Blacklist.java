// https://leetcode.com/problems/random-pick-with-blacklist/description/

// TC - O(B), B for length of blacklist
// SC - O(B)

import java.util.*;

class Solution {
    HashMap<Integer, Integer> map;
    Random r;
    int top;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        top = n - blacklist.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < blacklist.length; i++) {
            set.add(blacklist[i]);
        }

        n--;
        
        for(int i = 0; i < blacklist.length; i++) {
            if(blacklist[i] < top) {
                while(set.contains(n) == true) n--;
                map.put(blacklist[i], n);
                n--;
            }
        }    
    }
    
    public int pick() {
        int randIdx = r.nextInt(top);
        if(map.containsKey(randIdx)) return map.get(randIdx);

        return randIdx;
    }
}
