// https://practice.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution
{
    long subCount(long nums[] ,int n,int k)
    {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) {
                rem += k;
            }
            
            count += map.getOrDefault(rem, 0);
            
            if(map.containsKey(rem)) {
                int freq = map.get(rem);
                map.put(rem, freq + 1);
            }
            else {
                map.put(rem, 1);
            }
        }
        
        return count;
    }
}