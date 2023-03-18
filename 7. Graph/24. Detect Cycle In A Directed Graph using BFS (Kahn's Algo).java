// https://www.codingninjas.com/codestudio/problems/1062626

// BFS Approach

// TC - O(V + E) 
// SC - O(N)

import java.util.*;

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

  
    return topoSort_BFS(graph, n);
  }

  public static boolean topoSort_BFS(ArrayList<ArrayList<Integer>> graph, int N) {
    int[] indegree = new int[N + 1];
    for(int i = 1; i < N + 1; i++) {
      for(int nbr : graph.get(i)) {
        indegree[nbr]++;
      }
    }

    Queue<Integer> que = new ArrayDeque<>();
    for(int i = 1; i < N + 1; i++) {
      if(indegree[i] == 0) {
        que.add(i);
      }
    }

    int count = 0;

    while(que.size() > 0) {
      int size = que.size();

      while(size-- > 0) {
        int remVertex = que.remove();
        
        count++;

        for(int nbr: graph.get(remVertex)) {
          indegree[nbr]--;
          if(indegree[nbr] == 0) {
            que.add(nbr);
          }
        }
      }
    }

    if(count == N) return false;
    return true;
  }
}