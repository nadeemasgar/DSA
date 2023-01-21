// https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution
{
    public static long countKdivPairs(int nums[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        
        for(int num : nums) {
            int rem = num % k;
            
            if(rem != 0) {
                count += map.getOrDefault(k - rem, 0);
            }
            else {
                count += map.getOrDefault(0, 0);
            }
            
            int freq = map.getOrDefault(rem, 0);
            map.put(rem, freq + 1);
        }
        
        return count;
    }
}