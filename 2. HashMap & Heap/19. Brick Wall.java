// https://leetcode.com/problems/brick-wall/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> list : wall) {
            int sum = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                int freq = map.getOrDefault(sum, 0);
                map.put(sum, freq + 1);
            }
        }

        int res = wall.size();
        for(int key: map.keySet()) {
            int val = map.get(key);
            res = Math.min(res, wall.size() - val);
        }

        return res;
    }
}