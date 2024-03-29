// https://www.pepcoding.com/resources/online-java-foundation/graphs/is_graph_cyclic/topic

// BFS does not work to detect cycle in directed graph. For this, KAHN'S ALGO is used


import java.io.*;
import java.util.*;

class Solution {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] vis) {
       
       Queue<Integer> q = new ArrayDeque<>();
       
       q.add(src);
       
       while(q.size() > 0) {
           
           int size = q.size();
           
           while(size-- > 0) {
               
               int u = q.remove();
               
               if(vis[u] == true) {
                   return true;
               }
               
               vis[u] = true;
               
               for(Edge e : graph[u]) {
                   
                   int nbr = e.nbr;
                   
                   if(vis[nbr] == false) {
                       q.add(nbr);
                   } 
               }
           }
       }
       
       return false;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      
      boolean[] vis = new boolean[vtces];

      for(int i = 0; i < vtces; i++) {
          boolean ans = false;
          if(vis[i] == false) {
              ans = isCyclic(graph, 0, vis);
          }
          
          if(ans == true) {
              System.out.println("true");
              return;
          }
      }
      
      System.out.println("false");
   }
}