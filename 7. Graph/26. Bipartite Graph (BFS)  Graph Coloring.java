// https://leetcode.com/problems/is-graph-bipartite/description/

// TC - O(V + E) 
// SC - O(N)

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for(int i = 0; i < V; i++) {
           color[i] = -1;
        }

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(bfsCheck(graph, i, color) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean bfsCheck(int[][] graph, int src, int[] color) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(src);
        color[src] = 1;

        while(!que.isEmpty()) {
            int size = que.size();

            while(size-- > 0) {
                int remVertex = que.remove();

                for(int nbr : graph[remVertex]) {
                    if(color[nbr] == -1) {
                        color[nbr] = 1 - color[remVertex];
                        que.add(nbr);
                    }
                    else if(color[nbr] == color[remVertex]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    } 
}