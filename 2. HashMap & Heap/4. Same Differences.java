// https://codeforces.com/contest/1520/problem/D

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    int countPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = nums[i] - (i + 1);
            int freq = map.getOrDefault(diff, 0);
            map.put(diff, freq + 1);
        }

        int total = 0;
        for(int key : map.keySet()) {
            int freq = map.get(key);
            total += (freq * (freq - 1)) / 2;
        }

        return total;
    }
}