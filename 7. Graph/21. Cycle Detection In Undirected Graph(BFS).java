// https://www.codingninjas.com/codestudio/problems/1062670

// BFS Approach

// TC - O(V + E) 
// SC - O(E)

import java.util.*;

class Solution {
    
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
                boolean flag = BFS(graph, i, vis);
                if(flag) return "Yes";
            }
        }

        return "No";
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {
        Queue<int[]> que = new ArrayDeque<>();// [src, parent]
        que.add(new int[]{src, -1});

        while(que.size() > 0) {
            int size = que.size();
            while(size-- > 0) {
                int[] node = que.remove();
                int remVertex = node[0];
                int par = node[1];

                vis[remVertex] = true;

                for(int nbr : graph.get(remVertex)) {
                    if(vis[nbr] == false) {
                        que.add(new int[]{nbr, remVertex});
                    }
                    else if(par != nbr){
                        return true;
                    }
                }
            }
        }

        return false;
    } 
}