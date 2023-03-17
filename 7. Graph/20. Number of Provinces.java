// https://practice.geeksforgeeks.org/problems/number-of-provinces/1

// TC - O(V ^ 2)
// SC - O(V)

import java.util.*;

class Solution {
    // Adjacency matrix is given
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                count++;
                DFS(adj, i, vis, V);
            }
        }
        
        return count;
    }
    
    static void DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, int V) {
        
        vis[src] = true;
        
        for(int i = 0; i < V; i++) { // check for each vertex if there is a path available
            if(!vis[i] && adj.get(src).get(i) == 1) {
                DFS(adj, i, vis, V);
            }
        }
    }
};