// https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1

import java.util.*;

// Dijkstra Algo 
// Time Complexity: O(n * m) - We will be visiting each cell only once.
// Space Complexity: O(n * m) - We are maintaining a visited array.

class Solution {
    class Pair {
        int row, col, dis;
        Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.dis = d;
        }
     }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length, m = grid[0].length;
        
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        
        Queue<Pair> que = new ArrayDeque<>();
        dist[source[0]][source[1]] = 0;
        que.add(new Pair(source[0], source[1], 0));
        
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair rem = que.remove();
                int r = rem.row;
                int c = rem.col;
                int dis = rem.dis;
                
                if(r == destination[0] && c == destination[1]) return dis;
                
                for(int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && dis + 1 < dist[nr][nc]) {
                        dist[nr][nc] = dis + 1;
                        que.add(new Pair(nr, nc, dis + 1));
                    }
                }
            }
        }
        
        return -1;
    }
}

// Normal BFS

class Solution2 {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length, m = grid[0].length, shortestPath = 0;
        
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        que.addLast(source[0] * m + source[1]);
        grid[source[0]][source[1]] = -1;
        
        while(que.size() != 0) {
            int size = que.size();
            
            while(size-- != 0) {
                int idx = que.removeFirst();
                
                int i = idx / m , j = idx % m;
                
                if(i == destination[0] && j == destination[1]) {
                    return shortestPath;
                }
                
                for(int d = 0; d < 4; d++) {
                    int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = -1;
                        que.add(nr * m + nc);
                    }
                }
            }
            
            shortestPath++;
        }
        
        return -1;
    }
}