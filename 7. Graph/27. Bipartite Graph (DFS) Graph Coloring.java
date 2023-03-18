// https://leetcode.com/problems/is-graph-bipartite/description/

// TC - O(V + E) 
// SC - O(N)

class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for(int i = 0; i < V; i++) {
           color[i] = -1;
        }

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(dfsCheck(graph, i, color) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean dfsCheck(int[][] graph, int src, int[] color) {
        
        if(color[src] == -1) color[src] = 1;

        for(int nbr : graph[src]) {
            if(color[nbr] == -1) {
                color[nbr] = 1 - color[src];
                if(dfsCheck(graph, nbr, color) == false) return false;         
            }
            else if(color[nbr] == color[src]) {
                return false;
            }
        }

        return true;
    } 
}