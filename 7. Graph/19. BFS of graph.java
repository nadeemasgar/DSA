// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

// TC: O(V+E)
// SC: O(V)

import java.util.*;

class Solution1 {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean[] vis = new boolean[V];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                int currNode = que.remove();
                
                if(vis[currNode]) continue;
                
                vis[currNode] = true;
                ans.add(currNode);
                
                for(int nbr: adj.get(currNode)) {
                    if(vis[nbr] == false) {
                        que.add(nbr);
                    }
                }
            }
        }
        
        return ans;
    }
}

// BFS for Disconnected Graph:

// To print all the vertices, 
// we can modify the BFS function to do traversal starting from all nodes one by one (Like the DFS modified version). 

class Solution2 {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if (vis[i] == false) {
                Queue<Integer> que = new ArrayDeque<>(); 
                que.add(i);
                
                while(que.size() > 0) {
                    int currNode = que.remove();
                
                    if(vis[currNode]) continue;
                    
                    vis[currNode] = true;
                    ans.add(currNode);
                    
                    for(int nbr: adj.get(currNode)) {
                        if(vis[nbr] == false) {
                            que.add(nbr);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}