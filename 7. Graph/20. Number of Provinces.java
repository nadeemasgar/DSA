// https://practice.geeksforgeeks.org/problems/number-of-provinces/1
// https://leetcode.com/problems/number-of-provinces/description/

// TC - O(V ^ 2)
// SC - O(V)

import java.util.*;

class Solution1 {
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

// Adjacency Matrix of a graph is given
// TC - O(N ^ 2)
// SC - O(N)

class Solution2 {
    public int findCircleNum(int[][] island) {
        int V = island.length;
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                DFS(island, i, vis);
                count++;
            }
        }

        return count;
    }

    public void DFS(int[][] island, int i, boolean[] vis) {
        vis[i] = true;

        for(int j = 0; j < island.length; j++) {
            if(vis[j] == false && island[i][j] == 1) {
                DFS(island, j, vis);
            }
        }
    }
}