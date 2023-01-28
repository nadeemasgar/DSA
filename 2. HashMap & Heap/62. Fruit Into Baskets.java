// https://leetcode.com/problems/fruit-into-baskets/description/

// Same as Longest Substring with At Most K Distinct Characters

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < fruits.length){
            int n = fruits[end];
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) == 1) counter++;//new fruit
            end++;
            while(counter > 2){
                int nTemp = fruits[start];
                map.put(nTemp, map.get(nTemp) - 1);
                if(map.get(nTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        
        return len;
    }
}