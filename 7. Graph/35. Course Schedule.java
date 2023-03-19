// https://leetcode.com/problems/course-schedule/

// TC - O(V + E) 
// SC - O(V + E)

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
            
        for(int[] edges : prerequisites) {
            int e = edges[0];
            int v = edges[1];
            graph[e].add(v);
            indegree[v]++;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++) 
            if(indegree[i] == 0) que.add(i);
       
        int count = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                int remVertex = que.remove();
                
                count++;
                
                for(int nbr : graph[remVertex]) {
                    indegree[nbr]--;

                    if(indegree[nbr] == 0)
                        que.add(nbr);
                }
            }
        }
        
        if(count == numCourses)
            return true;
        else 
            return false;
    }
}