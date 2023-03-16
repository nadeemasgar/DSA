// https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1

// TC - O(V + E)

import java.util.*;

class Solution {
    // Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph( int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // iterating over each vertex.
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            // pushing the vertex at ith index and all the
            // nodes connected to it in the output list.
            temp.add(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                temp.add(adj.get(i).get(j));
            }
            ans.add(temp);
        }
        // returning the list.
        return ans;
    }
}