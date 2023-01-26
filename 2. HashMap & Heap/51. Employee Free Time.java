// https://leetcode.com/problems/employee-free-time/description/

// TC - O(N * log N) 
// SC - O(N)

import java.util.*;


// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for(List<Interval> period : schedule) {
            for(Interval s : period) {
                pq.add(s);
            }
        }
        Interval curr = pq.poll();
        while(pq.size() > 0) {
            if(curr.end >= pq.peek().start) { // curr: [1, 2], pq.peek(): [1, 3]
                // one is overlapping
                Interval out = pq.poll();
                curr.end = Math.max(curr.end, out.end);
            }
            else {
                // the other is non-overlapping
                res.add(new Interval(curr.end, pq.peek().start));
                curr = pq.poll();
            }
        }

        return res;
    }
}