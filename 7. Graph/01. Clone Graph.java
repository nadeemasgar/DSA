// https://leetcode.com/problems/clone-graph/description/

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// DFS Approach
// TC - O(V + E)  where V is a number of nodes (vertices) and E is a number of edges.
// SC - O(V) 

class Solution1 {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    public Node cloneGraph(Node node, HashMap <Node, Node> visited) {
        if (node == null) return node;
       
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node root = new Node(node.val);
        visited.put(node, root);

        for (Node neighbor: node.neighbors) {
            root.neighbors.add(cloneGraph(neighbor, visited));
        }

        return root;
    }
}


// BFS Approach

class Solution2 {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        Map<Node, Node> map = new HashMap<>(); // original graph vs clone graph
        map.put(node, new Node(node.val));

        while(!q.isEmpty()) {
            Node current = q.poll();
            for(Node ng: current.neighbors) {
                if(!map.containsKey(ng)) {
                    map.put(ng, new Node(ng.val));
                    q.add(ng);
                }

                map.get(current).neighbors.add(map.get(ng));
            }
        }

        return map.get(node);
    }
}