// https://practice.geeksforgeeks.org/problems/number-of-provinces/1

import java.util.*;

class Solution {
    // GFG Template
    // https://practice.geeksforgeeks.org/problems/number-of-provinces/1

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
       DSU ds = new DSU(V);
       
       for(int i = 0; i < V; i++) {
           for(int j = 0; j < V; j++) {
               if(adj.get(i).get(j) == 1) {
                   ds.union(i, j);
               }
           }
       }
       
       int cnt = 0; 
       for(int i = 0; i < V; i++) {
           if(ds.par[i] == i) cnt++;
       }
       
       return cnt;
    }

    // Leetcode Template
    // https://leetcode.com/problems/number-of-provinces/description/

    public int findCircleNum(int[][] edges) {
        int V = edges.length;
        DSU ds = new DSU(V);
       
       for(int i = 0; i < V; i++) {
           for(int j = 0; j < V; j++) {
               if(edges[i][j] == 1) {
                   ds.union(i, j);
               }
           }
       }
       
       int cnt = 0; 
       for(int i = 0; i < V; i++) {
           if(ds.par[i] == i) cnt++;
       }
       
       return cnt;
    }
};

class DSU {
	int n;
	int par[], size[];
	
	DSU(int n) {
		this.n = n;
		this.par = new int[n];
		this.size = new int[n];
		
		for(int i = 0; i < n; i++) par[i] = i;
	}
	
	int find(int node){
		if(par[node] == node)
			return node;
		return par[node] = find(par[node]);
	}
	
	boolean union(int u, int v){
		int p1 = find(u);
		int p2 = find(v);
		
		if(p1 == p2) return false;
		
		if(size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] += size[p1];
        }
        else {
            par[p2] = p1;
            size[p1] = size[p2];
        }
        
		return true;
	}
}