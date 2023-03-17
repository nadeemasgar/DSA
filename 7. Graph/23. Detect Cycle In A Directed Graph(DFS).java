// https://www.codingninjas.com/codestudio/problems/1062626

// DFS Approach

// TC - O(V + E) 
// SC - O(N)

import java.util.ArrayList;

class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for(ArrayList<Integer> edge: edges) {
      int u = edge.get(0), v = edge.get(1);
      graph.get(u).add(v);
    }

    boolean[] vis = new boolean[n + 1];
    boolean[] dfsVis = new boolean[n + 1];

    for(int i = 1; i < n + 1; i++) {
      if(vis[i] == false) {
        if(DFS(graph, i, vis, dfsVis) == true) return true;
      }
    }

    return false;
  }

  public static boolean DFS(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, boolean[] dfsVis) {
    vis[src] = true;
    dfsVis[src] = true;

    for(int nbr : graph.get(src)) {
      if(vis[nbr] == false) {
        if(DFS(graph, nbr, vis, dfsVis) == true) return true;
      }
      else if(dfsVis[nbr] == true) {
        return true;
      }
    }

    dfsVis[src] = false;
    
    return false;
  }
}