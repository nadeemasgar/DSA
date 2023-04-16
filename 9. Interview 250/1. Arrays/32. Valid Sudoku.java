// https://leetcode.com/problems/valid-sudoku/description/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                
                char d = board[i][j];
                
                if(d != '.') {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    boolean ans = isValid(board, i, j, d);
                    board[i][j] = temp;
                    if(ans == false) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char d) {
      
      // ith row check
      for(int c = 0; c < 9; c++) {
          if(board[i][c] == d) {
              return false;
          }
      }
      
      // jth col check
      for(int r = 0; r < 9; r++) {
          if(board[r][j] == d) {
              return false;
          }
      }
      
      // submatrix check
      int smrs = (i/3) * 3;
      int smcs = (j/3) * 3;
      
      for(int r = 0; r < 3; r++) {
          for(int c = 0; c < 3; c++) {
              if(board[smrs + r][smcs + c] == d) {
                  return false;
              }
          }
      }
      
      return true;
  }
}