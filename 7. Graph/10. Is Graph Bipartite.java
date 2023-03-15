// https://www.pepcoding.com/resources/online-java-foundation/graphs/is_graph_bipartite/topic

import java.io.*;
import java.util.*;

public class Main {
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
   
   public static class Pair {
       int v;
       int state;
       
       Pair(int v, int state) {
           this.v = v;
           this.state = state;
       }
   }
   
   public static boolean BFS(ArrayList<Edge>[] graph, int src, int[] vis) {
       
       Queue<Pair> q = new ArrayDeque<>();
       
       q.add(new Pair(src,1));
       
       while(q.size() > 0) {
           
           int size = q.size();
           
           while(size-- > 0) {
               
               Pair rem = q.remove();
               
               if(vis[rem.v] != 0) {
                   
                   if(vis[rem.v] != rem.state) {
                       return false;
                   }
                   continue;
               }
               
               vis[rem.v] = rem.state;
               
               for(Edge e : graph[src]) {
                   int nbr = e.nbr;
                   int state = rem.state == 2? 1 : 2; 
                   if(vis[nbr] == 0) {
                      q.add(new Pair(nbr, state)); 
                   }
               }
           }
       }
       
       return true;
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
      
      int[] vis = new int[vtces];

      for(int i = 0; i < vtces; i++) {
          
          if(vis[i] == 0) {
              boolean ans = BFS(graph, i,  vis);
              if(ans == false) {
                  System.out.println("false");
                  return;
              }
          }
      }
      
      System.out.println("true");
      
   }
}