// https://practice.geeksforgeeks.org/problems/morning-assembly3038/1

// TC - O(n)
// SC - O(n)

import java.util.*;

class Solution{
    static int sortingCost(int N, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSeq = 1;
        
        for(int num : arr) {
            if(map.containsKey(num - 1)) {
                int seq = map.get(num - 1);
                map.put(num, seq + 1);
                maxSeq = Math.max(maxSeq, seq + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        
        return N - maxSeq;
    }
}