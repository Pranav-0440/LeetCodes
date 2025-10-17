import java.util.*;

class Solution {
    
    // Function to check if placing a queen at (row, col) is safe
    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        
        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check upper-left diagonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check upper-right diagonal
        for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    // Recursive backtracking function
    private void solve(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            // Construct the solution as a list of strings
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }
        
        // Try placing a queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';          // Place queen
                solve(board, row + 1, result);  // Move to next row
                board[row][col] = '.';          // Backtrack
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Start backtracking from row 0
        solve(board, 0, result);
        return result;
    }
}
