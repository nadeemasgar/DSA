// https://leetcode.com/problems/redundant-connection/description/

class Solution {
    
    static int[] parent;
    static int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        parent = new int[n + 1]; // index 0 is blocked as it has 1 based indexing
        rank = new int[n + 1];
        
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            // Union by rank
            int lu = find(u);
            int lv = find(v);
            
            if(lu != lv) {
                
                if(rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                }
                else if(rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                }
                else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            }
            else {
                int[] ans = {u,v};
                return ans;
            }
        }
        
        return null;
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int temp = find(parent[x]);
        parent[x] = temp;
        
        return temp;
    }
}