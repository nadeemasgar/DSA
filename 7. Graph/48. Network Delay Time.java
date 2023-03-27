// https://leetcode.com/problems/network-delay-time/description/

// TC - E log V
// SC: O(V)

import java.util.*;

class Solution {
    class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            graph.get(u).add(new Pair(v, wt)); 
        }

        int[] dist = new int[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));

        while(pq.size() > 0) {
            int node = pq.peek().first;
            int dis = pq.peek().second;
            pq.remove();

            for(Pair it : graph.get(node)) {
                int nbr = it.first;
                int wt = it.second;

                if(dis + wt < dist[nbr]) {
                    dist[nbr] = dis + wt;
                    pq.add(new Pair(nbr, dist[nbr]));
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            else {
                maxTime = Math.max(maxTime, dist[i]);
            }
        }

        return maxTime;
    }
}