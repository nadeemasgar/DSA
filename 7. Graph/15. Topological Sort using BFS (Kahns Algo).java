import java.util.*;

class Solution {
    public static int[] topoSort(ArrayList<ArrayList<Integer>> graph, int N) {
        int[] topo = new int[N];
        int[] indegree = new int[N];
        for(int i = 0; i < N; i++) {
          for(int nbr : graph.get(i)) {
            indegree[nbr]++;
          }
        }
    
        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
          if(indegree[i] == 0) {
            que.add(i);
          }
        }
    
        int idx = 0;
    
        while(que.size() > 0) {
          int size = que.size();
    
          while(size-- > 0) {
            int remVertex = que.remove();
            topo[idx++] = remVertex;
    
            for(int nbr: graph.get(remVertex)) {
              indegree[nbr]--;
              if(indegree[nbr] == 0) {
                que.add(nbr);
              }
            }
          }
        }
    
        return topo;
      }
}