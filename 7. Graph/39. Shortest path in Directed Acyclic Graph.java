// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

// TC - O(V+E)
// SC - O(V+E)

import java.util.*;

class Solution {
    
    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
		    graph.add(new ArrayList<Pair>());
		}
		
		for(int i = 0; i < M; i++) {
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    
		    graph.get(u).add(new Pair(v, wt));
		}
		
		// Find the Topo Sort
        // O(N + M)
		boolean[] vis = new boolean[N];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++) {
		    if(vis[i] == false) {
		        topoSort(graph, i, vis, st);
		    }
		}
		
		// Step 2 do the distance thing
		int[] dist = new int[N];
		Arrays.fill(dist, (int)1e9);
		
		dist[0] = 0;
		
		// O(N + M)
		while(!st.isEmpty()) 
		{
		    int remVertex = st.pop();

    	    for(Pair edge : graph.get(remVertex)){
    	        int nbr = edge.first;
    	        int wt = edge.second;
    	          
    	        if(dist[remVertex] + wt < dist[nbr] ){
    	            dist[nbr] = dist[remVertex] + wt;
    	        }
    	   }  
		  
		}
		
		for(int i = 0; i < N; i++){
		    if(dist[i] == (int)1e9)
		        dist[i] = -1;
		}
		
		return dist;
	}
	
	public void topoSort(ArrayList<ArrayList<Pair>> graph, int src, boolean[] vis, Stack<Integer> st) {
	    vis[src] = true;
	    
	    for(Pair edge : graph.get(src)) {
	        int nbr = edge.first;
	        if(vis[nbr] == false) {
	            topoSort(graph, nbr, vis, st);
	        }
	    }
	    
	    st.add(src);
	}
}