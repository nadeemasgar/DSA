// https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian_path_and_cycle/topic

// A hamiltonian path is such which visits all vertices without visiting any twice. 
// A hamiltonian path becomes a cycle if there is an edge between first and last vertex.

// TC - O(V+E)

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
   
   public static void hamiltonian(ArrayList<Edge>[] graph, int src, int osrc, boolean[] vis, String psf) {
       
       if(psf.length() == graph.length) {
           
           for(Edge e : graph[src]) {
               
               if(e.nbr == osrc) {
                   System.out.println(psf + "*");
                   return;
               } 
           }
           
           System.out.println(psf + ".");
           return;
       }
       
       
       vis[src] = true;
       
       ArrayList<Edge> edges = graph[src];
       
       for(Edge e : edges) {
           
           if(vis[e.nbr] == false) {
               hamiltonian(graph, e.nbr, osrc, vis, psf + e.nbr);
           }
       }
       
       vis[src] = false;
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
      boolean[] vis = new boolean[vtces];
      
      hamiltonian(graph, src, src, vis, "" + src);
   }

}