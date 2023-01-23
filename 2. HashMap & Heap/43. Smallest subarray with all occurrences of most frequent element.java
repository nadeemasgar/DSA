// https://practice.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution{
  
    ArrayList<Integer> smallestSubsegment(int arr[], int n)
    {
        HashMap<Integer, Integer> freq_map = new HashMap<>();
        HashMap<Integer, Integer> start_index_map = new HashMap<>(); // starting occurence
        
        int maxFreq = 0;
        int si = 0;
        int ei = 0;
        int maxLen = ei - si + 1;
        
        for(int i = 0; i < arr.length; i++) {
            if(freq_map.containsKey(arr[i])) {
                freq_map.put(arr[i], freq_map.get(arr[i]) + 1);
            }
            else {
                freq_map.put(arr[i], 1);
                start_index_map.put(arr[i], i);
            }
            
            if(freq_map.get(arr[i]) > maxFreq) {
                maxFreq = freq_map.get(arr[i]);
                si = start_index_map.get(arr[i]); 
                ei = i;
                maxLen = ei - si + 1;
            }
            else if(freq_map.get(arr[i]) == maxFreq) {
                int curr_len = i - start_index_map.get(arr[i]) + 1;
                if(curr_len < maxLen) {
                    maxFreq = freq_map.get(arr[i]);
                    si = start_index_map.get(arr[i]); 
                    ei = i;
                    maxLen = ei - si + 1;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = si; i <= ei; i++) {
            list.add(arr[i]);
        }
        
        return list;
    }   
}