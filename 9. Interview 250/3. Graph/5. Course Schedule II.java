// https://leetcode.com/problems/course-schedule-ii/description/

// TC - O(V + E) 
// SC - O(V + E)

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topo = new int[numCourses];
        int[] indegree = new int[numCourses];
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
            
        for(int[] edges : prerequisites) {
            int e = edges[0];
            int v = edges[1];
            graph[v].add(e);
            indegree[e]++;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++) 
            if(indegree[i] == 0) que.add(i);
       
        int idx = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                int remVertex = que.remove();
                
                topo[idx++] = remVertex;
                        
                for(int nbr : graph[remVertex]) {
                    indegree[nbr]--;

                    if(indegree[nbr] == 0) {
                        que.add(nbr);
                    }  
                }
            }
        }
        
        if(idx != numCourses) {
            return new int[0];
        }
        
        return topo;
    }
}