// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/

import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for(int i = 0; i < k; i++) {
            int mol = nums.get(i).get(0); // Minimum of List
            int[] tba = {mol, 0, i}; // To be Added
            // 0th - Minimum element of the list
            // 1st - Index of element from the list
            // 2nd - Index of list in nums
            max = Math.max(max, mol);
            pq.add(tba);
        }

        while(true) {
            int[] min = pq.poll();
            if(res[1] - res[0] > max - min[0]) { // result updated
                res[0] = min[0];
                res[1] = max;
            }

            min[1]++;
            List<Integer> cl = nums.get(min[2]); // current list
            if(min[1] == cl.size()) {
                break;
            }
            else {
                min[0] = cl.get(min[1]);
                max = Math.max(max, min[0]);
                pq.add(min);
            }
        }

        return res;
    }
}