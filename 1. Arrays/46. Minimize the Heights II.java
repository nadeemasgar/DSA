// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1

import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int currmin = arr[0];
        int currmax = arr[n - 1];
        int ans = currmax - currmin;
        
        for(int i = 1; i < n; i++) {

            if (arr[i] - k < 0)  // if on subtracting k we got negative then continue
                continue;
            
            currmin = Math.min(arr[0] + k, arr[i] - k); // Minimum element when we add k to whole array
            currmax = Math.max(arr[i - 1] + k, arr[n - 1] - k); // Maximum element when we subtract k from whole array
            
            ans = Math.min(ans, currmax - currmin);
        }
        
        return ans;
    }
}