// https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int nums[], int n)
    {
        // Changing 0s to -1
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            
            count += map.getOrDefault(sum, 0);
            
            if(map.containsKey(sum) == false) {
                map.put(sum, 1);
            }
            else {
                int freq = map.get(sum);
                map.put(sum, freq + 1);
            }
        }
        
        return count;
    }
}