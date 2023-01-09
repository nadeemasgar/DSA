// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

import java.util.*;

// TC - O(n)
// SC - O(n)

class Solution {
    
    public long[] printFirstNegativeInteger(long nums[], int n, int k)
    {
        Deque<Integer> q = new ArrayDeque<>();
        long[] ans = new long[n-k+1];
        int idx = 0;
        
        for(int i = 0; i < n; i++) {
            // removes number out of range k
            if(!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            
            if(nums[i] < 0) {
                q.offer(i);
            }
            
            if(i >= k - 1) {
                if(q.isEmpty()) { // no negative element in window
                    ans[idx++] = 0;
                }
                else {
                    ans[idx++] = (long)nums[q.peek()];
                }
            }
        }
        
        return ans;
    }
}