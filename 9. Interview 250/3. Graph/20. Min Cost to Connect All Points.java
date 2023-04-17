// https://leetcode.com/problems/min-cost-to-connect-all-points/description/

import java.util.*;

class Solution {
    static int[] par;
    
    public int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
    
    public int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                list.add(new int[] {distance(points, i, j), i, j});
            }
        }
        
        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });
        
        par = new int[n];
        
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
        
        int cost = 0;
        
        for(int[] e : list) {
            int u = e[1], v = e[2], w = e[0];
            int p1 = findPar(u), p2 = findPar(v);
            
            if(p1 != p2) {
                par[p1] = p2;
                cost += w;
            }
        }
        
        return cost;
    }
}