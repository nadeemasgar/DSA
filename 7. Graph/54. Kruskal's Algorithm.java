// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.*;

// TC - O(E * logV) 
// SC - O(V + E)

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
        Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int x[], int y[]){
				return x[2] - y[2];
			}
		});
		
		int ans = 0;
		
		DSU dsu = new DSU(V);
		
		for(int i = 0; i < E; i++){
			if(dsu.union(edges[i][0], edges[i][1]))
				ans += edges[i][2];
		}
		
		return ans;
    }
}
    
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