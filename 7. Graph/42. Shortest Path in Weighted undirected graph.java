// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

// TC: O(E log V)
// SC: O(V)

import java.util.*;

class Solution {
    static class Pair {
        int node, distance;
        Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        
        dist[1] = 0;
        pq.add(new Pair(1, 0));
        // 's Algo
        while(pq.size() != 0) {
            Pair rem = pq.remove();
            int node = rem.node;
            int distance = rem.distance;
            
            for(Pair edge : graph.get(node)) {
                int nbr = edge.node;
                int wt = edge.distance;
                if(distance + wt < dist[nbr]) {
                    dist[nbr] = distance + wt;
                    pq.add(new Pair(nbr, dist[nbr]));
                    parent[nbr] = node;
                }
            }
        }
        // ansewer preparing
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }
        
        int node = n;
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}