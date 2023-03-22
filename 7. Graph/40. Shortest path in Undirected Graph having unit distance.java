// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

// TC - O(V+E)
// SC - O(V+E)

import java.util.*;

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);
        
        while(!que.isEmpty()) {
            int remVertex = que.remove();
            for(int nbr : graph.get(remVertex)) {
                if(dist[remVertex] + 1 < dist[nbr]) {
                    dist[nbr] = dist[remVertex] + 1;
                    que.add(nbr);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}