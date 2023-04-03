// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
// https://leetcode.com/problems/subsets/

// TC- O(2^N)
// SC- O(2^N)

import java.util.*;

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList < Integer > sumSubset = new ArrayList < > ();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    
    void subsetSumsHelper(int ind, int sum, ArrayList < Integer > arr, int N, ArrayList < Integer > sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        // pick the element 
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        // Do-not pick the element
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }
}