// https://www.pepcoding.com/resources/online-java-foundation/graphs/breadth_first_traversal/topic

// TC - O(V + E)

import java.io.*;
import java.util.*;

class Solution {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair {
       int v;
       int lev;
       String psf;
       
       Pair(int v, int lev, String psf) {
           this.v = v;
           this.lev = lev;
           this.psf = psf;
       } 
   }
   
   public static void BFS(ArrayList<Edge>[] graph, int src, boolean[] visited) {
       Queue<Pair> que = new ArrayDeque<>();
       que.add(new Pair(src, 0, src + ""));
       
       while(que.size() > 0) {
           
           int size = que.size();
           
           while(size-- > 0) {
                Pair rem = que.remove();
                
                if(visited[rem.v] == true) {
                    continue;
                }
                
                System.out.println(rem.v + "@" + rem.psf);
                visited[rem.v] = true;
                
                for(Edge e : graph[rem.v]) {
                    if(visited[e.nbr] == false) {
                        que.add(new Pair(e.nbr, rem.lev + 1, rem.psf + e.nbr));
                    }
                }
           }
           
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      boolean[] visited = new boolean[vtces];
      BFS(graph, src, visited);
   }
}