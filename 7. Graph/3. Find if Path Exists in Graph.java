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

// BFS Approach

class Solution3 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Store all edges in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

            // For all the neighbors of the current node, if we haven't visit it before,            
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}