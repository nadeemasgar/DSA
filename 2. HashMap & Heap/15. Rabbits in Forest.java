// https://leetcode.com/problems/rabbits-in-forest/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int numRabbits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: arr) {
            int freq = map.getOrDefault(val, 0);
            map.put(val, freq + 1);
        }

        int ans = 0;
        for(int key: map.keySet()) {
            int gs = key + 1; // group size
            int reportees = map.get(key);
            int ng = (int)Math.ceil(reportees * 1.0 / gs * 1.0); // new group
            ans += ng * gs;
        }

        return ans;
    }
}