// https://www.pepcoding.com/resources/online-java-foundation/graphs/shortest_path_in_weights/topic

// Shortest Path In Weights (Dijkstra's algorithm) --> For weighted graph
// The weights of all edges are non-negative.

// In Dijkstra's algorithm, we were required to find the shortest path from source, 
// hence we required the total sum of weights from source to destination to be minimum.

// TC - O(E + V logV) 
// SC - O(V)

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
   
   public static class Pair implements Comparable<Pair>{
       int v;
       String psf;
       int wsf;
       
       Pair(int v, String psf, int wsf) {
           this.v = v;
           this.psf = psf;
           this.wsf = wsf;
       }
       
       public int compareTo(Pair o) {
           return this.wsf - o.wsf;
       }
   }
   
   public static void Dijskstra(ArrayList<Edge>[] graph, int src) {
       
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       
       boolean[] vis = new boolean[graph.length];
       
       pq.add(new Pair(src, src + "", 0));
       
       while(pq.size() > 0) {
           
           int size = pq.size();
           
           while(size-- > 0) {
               
               Pair rem = pq.remove();
               
               if(vis[rem.v] == true) {
                   continue;
               }
               
               vis[rem.v] = true;
               
               System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
               
               for(Edge e : graph[rem.v]) {
                   
                   int nbr = e.nbr;
                   if(vis[nbr] == false) {
                       pq.add(new Pair(nbr, rem.psf + nbr, rem.wsf + e.wt));
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      
      Dijskstra(graph, src);
      
   }
}