// https://www.codingninjas.com/codestudio/problems/1062670

// DFS Approach

// TC - O(V + E) 
// SC - O(E)

import java.util.*;

class Solution2 {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        
        for(int i=1; i < n + 1; i++) {
            if(vis[i] == false) {
                boolean flag = DFS(graph, i, -1, vis);
                if(flag) return "Yes";
            }
        }

        return "No";
    }

    public static boolean DFS(ArrayList<ArrayList<Integer>> graph, int src, int par, boolean[] vis) {
        
        vis[src] = true;

        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                if(DFS(graph, nbr, src, vis) == true) return true;
            }
            else if(nbr != par) {
                return true;
            }
        }

        return false;
    }
    
}