// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

import java.util.*;

// DFS Approach
// TC - O(V + E)  where V is a number of nodes (vertices) and E is a number of edges.
// SC - O(V + E)

class Solution1 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] vis = new boolean[n];

        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            List<Integer> list1 = graph.getOrDefault(a, new ArrayList<>());
            list1.add(b);
            graph.put(a, list1);

            List<Integer> list2 = graph.getOrDefault(b, new ArrayList<>());
            list2.add(a);
            graph.put(b, list2);
        }

        return dfs(graph, source, destination, vis);
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int src, int dest, boolean[] vis) {
        if(src == dest) return true;

        vis[src] = true;

        List<Integer> Edges = graph.get(src);

        for(int nbr: Edges) {
            if(!vis[nbr]) {
                boolean hasPath = dfs(graph, nbr, dest, vis);
                if(hasPath) return true;
            }
        }

        return false;
    }
}


// Solution2 in different way.. using Map function -> computeIfAbsent

class Solution2 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] vis = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        return dfs(graph, source, destination, vis);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int src, int dest, boolean[] vis) {
        if(src == dest) return true;

        vis[src] = true;

        List<Integer> Edges = graph.get(src);

        for(int nbr: Edges) {
            if(!vis[nbr]) {
                boolean hasPath = dfs(graph, nbr, dest, vis);
                if(hasPath) return true;
            }
        }

        return false;
    }
}