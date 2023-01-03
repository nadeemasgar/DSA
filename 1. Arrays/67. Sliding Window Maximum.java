import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public class Pair implements Comparable<Pair> {
        int ele;
        int idx;

        Pair(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }

        public int compareTo(Pair o) {
            return this.ele - o.ele;
        }
    }
    // Using Priority Queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 || k == 0)
            return nums;
        
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[n - k + 1];

        for(int i = 0, j = 0; i < n; i++) {
            if(i < k - 1) {
                pq.add(new Pair(nums[i], i));
                continue;
            }

            pq.add(new Pair(nums[i], i));
            Pair rem = pq.remove();
            while( rem.idx < i - k + 1) {
                rem = pq.remove();
            }
            ans[j] = rem.ele;
            j++;

            if(rem.idx <= i) {
                pq.add(rem);
            }
        }

        return ans;
    }
}