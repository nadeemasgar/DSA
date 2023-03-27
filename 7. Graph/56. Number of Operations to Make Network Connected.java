// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
// https://practice.geeksforgeeks.org/problems/connecting-the-graph/1

class Solution {

    public int Solve(int n, int[][] edges) {
        DSU ds = new DSU(n);
        
        int cntExtra = 0; // count extra edge
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if(ds.find(u) == ds.find(v)) {
                cntExtra++;
            }
            else {
                ds.union(u, v);
            }
        }
        
        int cntC = 0; // count extra component
        for(int i = 0; i < n; i++) {
            if(ds.par[i] == i) cntC++;
        }
        
        int ans = cntC - 1;
        
        if(cntExtra >= ans) return ans;
        return -1;
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