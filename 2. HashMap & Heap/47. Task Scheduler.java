// https://leetcode.com/problems/task-scheduler/description/

// TC - O(N log(N))
// SC - O(n)

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // MAX_HEAP
        pq.addAll(map.values());

        int cycles = 0;
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                if(!pq.isEmpty()) {
                    temp.add(pq.remove() - 1);
                }
            }

            for(int t : temp) {
                if(t > 0) pq.add(t);
            }

            cycles += pq.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}

// Using PriorityQueue and Queue

// TC - O(n)
// SC - O(n)

class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // MAX_HEAP
        pq.addAll(map.values());
        
        Queue<int[]> que = new ArrayDeque<>(); 

        int time = 0;
        while(!pq.isEmpty() || !que.isEmpty()) {
            
            time += 1;

            if(!pq.isEmpty()) {
                int task = pq.remove() - 1;
                if(task > 0) que.add(new int[]{task, time + n}); // task added to que with wait time
            }

            if(!que.isEmpty() && que.peek()[1] == time) { // if cooldown period over
                int rem_task = que.remove()[0];
                pq.add(rem_task);
            }
        }

        return time;
    }
}