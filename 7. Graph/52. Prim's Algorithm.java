// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

// TC - O(E log E)
// SC - O(E)

import java.util.*;

class Pair {
    int node;
    int distance;
    
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
	    for(int i = 0; i < V; i++) {
	        graph.add(new ArrayList<>());
	    }
	    
	    for(int[] edge : edges) {
	        int u = edge[0];
	        int v = edge[1];
	        int wt = edge[2];
	        
	        graph.get(u).add(new Pair(v, wt));
	        graph.get(v).add(new Pair(u, wt));
	    }
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
	    int[] vis = new int[V];
	    
	    // {node, wt}
	    pq.add(new Pair(0, 0));
	    int sum = 0;
	    
	    while(pq.size() > 0) {
	        int size = pq.size();
	        while(size-- > 0) {
	            int node = pq.peek().node;
	            int wt = pq.peek().distance;
	            pq.remove();
	            
	            if(vis[node] == 1) continue;
	            // add it to the mst
	            vis[node] = 1;
	            sum += wt;
	            
	            for(Pair it : graph.get(node)) {
	                int nbr = it.node;
	                int dis = it.distance;
	                
	                if(vis[nbr] == 0) {
	                    pq.add(new Pair(nbr, dis));
	                }
	            }
	        }
	    }
	    
	    return sum;
	}
}