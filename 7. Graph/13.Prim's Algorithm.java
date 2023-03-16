// https://www.pepcoding.com/resources/online-java-foundation/graphs/minimum-wire-to-connect-all-pcs-official/ojquestion

// Minimum Wire Required To Connect All Pcs

// Minimum Spanning Tree

// In prim's algorithm, we need the sum of all edges taken in spanning tree to be minimum. 
// So, instead of adding the summation of paths, we will require to add the edge weights directly into the priority queue.

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
       int par;
       int wt;
       
       Pair(int v, int par, int wt) {
           this.v = v;
           this.par = par;
           this.wt = wt;
       }
       
       public int compareTo(Pair o) {
            return this.wt - o.wt;
       }
   }
   
   public static void primsAlgo(ArrayList<Edge>[] graph, int src) {
       
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       
       boolean[] vis = new boolean[graph.length];
       
       pq.add(new Pair(src, -1, 0));
       
       while(pq.size() > 0) {
           
           int size = pq.size();
           
           while(size-- > 0) {
               
               Pair rem = pq.remove();
               
               if(vis[rem.v] == true) {
                   continue;
               }
               
               vis[rem.v] = true;
               
               if(rem.par != -1) {
                   System.out.println("[" + rem.v + "-" + rem.par + "@" + rem.wt + "]");
               }
               
               for(Edge e : graph[rem.v]) {
                   
                   int nbr = e.nbr;
                   if(vis[nbr] == false) {
                       pq.add(new Pair(nbr, rem.v, e.wt));
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
      
      int src = 0;
      primsAlgo(graph, 0);
   }

}