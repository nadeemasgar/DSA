// https://www.pepcoding.com/resources/online-java-foundation/graphs/spread_of_infection/topic

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
   
   static class Pair {
       int v;
       int t;
       
       Pair(int v, int t) {
           this.v = v;
           this.t = t;
       }
   }
   
   public static int BFS(ArrayList<Edge>[] graph, int src, int t, boolean[] vis) {
       
       Queue<Pair> q = new ArrayDeque<>();
       
       q.add(new Pair(src, 1));
       
       int count = 0;
       
       while(q.size() > 0) {
           
           int size = q.size();
           
           while(size-- > 0) {
               
               Pair rem = q.remove();
               
               if(vis[rem.v] == true) {
                   continue;
               }
               
               if(rem.t > t) {
                   return count;
               }
               
               count++;
               
               vis[rem.v] = true;
               
               for(Edge e : graph[rem.v]) {
                   
                   int nbr = e.nbr;
                   if(vis[nbr] == false) {
                       q.add(new Pair(nbr, rem.t + 1));
                   }
               }
           }
       }
       
       return count;
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
      int t = Integer.parseInt(br.readLine());
      
      boolean[] vis = new boolean[vtces];
      int ans = BFS(graph, src, t, vis);
      System.out.println(ans);
   }

}