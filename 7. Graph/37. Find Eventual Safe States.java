// https://leetcode.com/problems/find-eventual-safe-states/description/

import java.util.*;

// Using DFS Approach of Cycle Detection in Directed Graph

class Solution1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                dfsCheck(graph, i, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(check[i] == 1) safeNodes.add(i);
        }

        return safeNodes;
    }

    public boolean dfsCheck(int[][] graph, int src, int[] vis, int[] pathVis, int[] check) {
        vis[src] = 1;
        pathVis[src] = 1;
        check[src] = 0;

        // travel for adjacent nodes
        for(int nbr : graph[src]) {
            //  when the node is not visited
            if(vis[nbr] == 0) {
                if(dfsCheck(graph, nbr, vis, pathVis, check) == true) {
                    return true;
                }
            }
            else if(pathVis[nbr] == 1) {
                // if the node has been previously visited
                // but it has to be visited on the same path
                return true;
            }
        }

        check[src] = 1;
        pathVis[src] = 0;
        return false;
    }
}

// Using BFS Approach of Cycle Detection in Directed Graph

class Solution2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> graphRev = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graphRev.add(new ArrayList<>());
        }


        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int nbr : graph[i]) {
                graphRev.get(nbr).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) que.add(i);
        }

        while(!que.isEmpty()) {
            int size = que.size();

            while(size-- > 0) {
                int remVertex = que.remove();
                safeNodes.add(remVertex);
                for(int nbr : graphRev.get(remVertex)) {
                    indegree[nbr]--;
                    if(indegree[nbr] == 0) que.add(nbr);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}