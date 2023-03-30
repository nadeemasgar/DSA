// https://leetcode.com/problems/making-a-large-island/description/

import java.util.*;

class Solution {
    
    private boolean isValid(int nr, int nc, int n) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU ds = new DSU(n * n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // step-1
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;
                for(int dir = 0; dir < 4; dir++) {
                    int nr = row + dr[dir];
                    int nc = col + dc[dir];

                    if(isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nr * n + nc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // step 2
        int max = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                for(int dir = 0; dir < 4; dir++) {
                    int nr = row + dr[dir];
                    int nc = col + dc[dir];
                      
                    if(isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        components.add(ds.findPar(nr * n + nc));
                    }
                }

                int sizeTotal = 0;
                for(Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                  
                max = Math.max(max, sizeTotal + 1);
                System.out.println(sizeTotal);
            }
        }

        for(int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size.get(ds.findPar(cellNo)));
        }
        
        return max;
    }
}

class DSU {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DSU(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}