// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/

import java.util.*;

// My Solution at time of Revision

class Solution {
    public class Pair {
        int ele;
        int idx;
        int listIdx;

        Pair(int ele, int idx, int listIdx) {
            this.ele = ele;
            this.idx = idx;
            this.listIdx = listIdx;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.ele - b.ele;
        });

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] range = new int[2];

        for(int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            int ele = list.get(0);
            pq.add(new Pair(ele, 0, i));

            min = Math.min(min, ele);
            max = Math.max(max, ele);
            range[0] = min;
            range[1] = max;
        }

        while(true) {
            Pair rem = pq.remove();
            int ele = rem.ele;
            int idx = rem.idx;
            int listIdx = rem.listIdx;

            List<Integer> list = nums.get(listIdx);

            if(max - ele < range[1] - range[0]) {
                min = ele;
                range[0] = min;
                range[1] = max;
            }

            if(idx + 1 == list.size()) break;
            
            int nele = list.get(idx + 1);
            pq.add(new Pair(nele, idx + 1, listIdx));

            max = Math.max(max, nele);
        }

        return range;
    }
}

class Solution2 {
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