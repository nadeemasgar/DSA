// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.*;

class Solution {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        String[] dirS = {"U", "D", "L", "R"};
        int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayList<String> ans = new ArrayList<>();
        if(arr[0][0] == 0 || arr[n-1][n-1] == 0) return ans;
        floodFill(0, 0, n, arr, "", dirS, dir, ans);
       
        return ans;
    }
    
    public static void floodFill(int sr, int sc, int n, int[][] arr, String psf, String[] dirS, int[][] dir, ArrayList<String> ans) {
        
        if(sr == n - 1 && sc == n - 1) {
            ans.add(psf);
            return;
        }
        
        arr[sr][sc] = 0;
        for(int d = 0; d < dirS.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < n && c < n && arr[r][c] == 1) {
               
                floodFill(r, c, n, arr, psf + dirS[d], dirS, dir, ans);
               
            }
        }
        
         arr[sr][sc] = 1;
    }
}