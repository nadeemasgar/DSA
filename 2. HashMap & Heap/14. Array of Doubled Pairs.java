// https://leetcode.com/problems/array-of-doubled-pairs/description/

// TC - O(n log n )
// SC - O(n)

import java.util.*;

class Solution {
    public boolean canReorderDoubled(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int el : map.keySet()) {
            if(map.getOrDefault(el, 0) > 0) {
                int target = el < 0 ? el / 2 : el * 2;
                
                // odd check
                if(el < 0 && el % 2 != 0) return false;

                if(map.get(el) > map.getOrDefault(target, 0)) 
                    return false;

                map.put(target, map.get(target) - map.get(el));
            }
        }

        return true;
    }
}