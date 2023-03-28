// https://leetcode.com/problems/number-of-islands-ii/description/

import java.util.*;

class Solution {

    private boolean isValid(int nr, int nc, int n, int m) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        DSU ds = new DSU(n * m);
        int[][] vis = new int[n][m];

        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = positions.length;

        for(int i = 0; i < len; i++) {
            int row = positions[i][0];
            int col = positions[i][1];

            if(vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            // row - 1, col
            // row, col + 1
            // row + 1, col
            // row, col - 1

            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            for(int dir = 0; dir < 4; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                if(isValid(nr, nc, n, m) && vis[nr][nc] == 1) {
                    int nodeNo = row  * m + col;
                    int adjNodeNo = nr * m + nc;
                    if(ds.findPar(nodeNo) != ds.findPar(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }

            ans.add(cnt);
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
	
	int findPar(int node){
		if(par[node] == node)
			return node;
		return par[node] = findPar(par[node]);
	}
	
	boolean unionBySize(int u, int v){
		int p1 = findPar(u);
		int p2 = findPar(v);
		
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