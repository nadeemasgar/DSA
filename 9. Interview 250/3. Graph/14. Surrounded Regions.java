// https://leetcode.com/problems/surrounded-regions/description/

// TC - O(N) where N is the number of cells in the board.
// SC - O(N) where N is the number of cells in the board.

class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        
        // top boundary
        for(int j = 0; j < m; j++) {
            if(board[0][j] == 'O')
                dfs(board, 0, j);
        }
        
        // left boundary
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O')
                dfs(board, i, 0);
        }
        
        // bottom boundary
        for(int j = 0; j < m; j++) {
            if(board[n-1][j] == 'O')
                dfs(board, n-1, j);
        }
        
        // right boundary
        for(int i = 0; i < n; i++) {
            if(board[i][m-1] == 'O')
                dfs(board, i, m-1);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '$')
                    board[i][j] = 'O';
                else 
                    board[i][j] = 'X';
            }
        }
    }
    
    int[][] direction = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
    
    public void dfs(char[][] board, int i, int j) { 
        
        board[i][j] = '$';
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = i + direction[dir][0];
            int nc = j + direction[dir][1];
            
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O')
                dfs(board, nr, nc);
        }
    }
}