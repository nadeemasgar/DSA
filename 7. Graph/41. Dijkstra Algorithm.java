// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
// TC: O(V2)
// SC: O(V2)

import java.util.*;

class Solution
{
    static class Pair {
        int node;
        int distance;
        
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        dist[src] = 0;
        pq.add(new Pair(src, 0));
        
        while(pq.size() != 0) {
            Pair rem = pq.remove();
            int node = rem.node;
            int distance = rem.distance;
            
            for(ArrayList<Integer> edges : graph.get(node)) {
                int nbr = edges.get(0);
                int wt = edges.get(1);
                
                if(distance + wt < dist[nbr]) {
                    dist[nbr] = distance + wt;
                    pq.add(new Pair(nbr, dist[nbr]));
                }
            }
        }
        
        return dist;
    }
}