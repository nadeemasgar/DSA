// https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/

// Given Array of size n and a number k, find all elements that appear more than n/k times


// TC - O(N)
// SC - O(N)

import java.util.*;

class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] nums, int n, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
        }
        
        int count = 0;
        
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(freq > n / k) {
                count++;
            }
        }
        
        return count;
    }
}