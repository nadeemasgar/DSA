// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubstringKDistinct(nums, k) - countSubstringKDistinct(nums, k - 1);
    }

    public int countSubstringKDistinct(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, count = 0;
        while(end < nums.length){
            int n = nums[end];
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) == 1) counter++;//new char
            end++;
            
            while(counter > k){
                int nTemp = nums[start];
                map.put(nTemp, map.get(nTemp) - 1);
                if(map.get(nTemp) == 0){
                    counter--;
                }
                start++;
            }
            count += end-start; // Number of subarray ending at end
        }
        
        return count;
    }
}