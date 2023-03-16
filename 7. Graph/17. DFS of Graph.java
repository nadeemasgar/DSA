// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

// TC - O(V + E) where V is the number of vertices and E is the number of edges in the graph
// SC - O(V)

import java.util.*;

class Solution1 {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        DFS(adj, 0, vis, ans);
        
        return ans;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, ArrayList<Integer> ans) {
        
        vis[src] = true;
        
        ans.add(src);
        
        ArrayList<Integer> edges = adj.get(src);
        
        for(int nbr : edges) {
            if(vis[nbr] == false) {
                DFS(adj, nbr, vis, ans);
            }
        }
    }
}


// DFS for Disconnected Graph

class Solution2 {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                DFS(adj, 0, vis, ans);
            }
        }
        
        return ans;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, ArrayList<Integer> ans) {
        
        vis[src] = true;
        
        ans.add(src);
        
        ArrayList<Integer> edges = adj.get(src);
        
        for(int nbr : edges) {
            if(vis[nbr] == false) {
                DFS(adj, nbr, vis, ans);
            }
        }
    }
    
}

