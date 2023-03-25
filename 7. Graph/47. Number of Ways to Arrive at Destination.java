// https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

// TC - E log V
// SC: O(V)

import java.util.*;

class Solution {
    
    static class Pair {
        int first;
        int second;
        
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int t = road.get(2);
            graph.get(u).add(new Pair(v, t));
            graph.get(v).add(new Pair(u, t));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.second - y.second);
        int[] dist = new int[n];
        int[] ways = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        
        pq.add(new Pair(0, 0));
        int mod = (int)(1e9 + 7);
        
        while(pq.size() != 0) {
            int node = pq.peek().first;
            int dis = pq.peek().second;
            pq.remove();
            
            for(Pair it : graph.get(node)) {
                int nbr = it.first;
                int wt = it.second;
                
                // this is the first time I am coming with this short distance
                if(dis + wt < dist[nbr]) {
                    dist[nbr] = (dis + wt) % mod;
                    pq.add(new Pair(nbr, dist[nbr]));
                    ways[nbr]  = ways[node];
                }
                else if(dis + wt == dist[nbr]) {
                    ways[nbr] = (ways[nbr] + ways[node]) % mod;
                }
            }
        }
        
        return ways[n - 1] % mod;
    }
}
