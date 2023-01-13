// https://www.geeksforgeeks.org/check-whether-arithmetic-progression-can-formed-given-array/

import java.util.*;

// TC - O(n)
// SC - O(n)

class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        if(arr.length <= 1) return true;
        
        HashSet<Integer> set = new HashSet<>();
        int min = (int)1e9;
        int max = -(int)1e9;
        
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }
        
        int d = (max - min) / (n - 1); // using AP Formula
        for(int i = 0; i < n; i++) {
            int ai = min + i * d; // using AP Formula
            if(set.contains(ai) == false)
                return false;
        }
        
        return true;
    }
}