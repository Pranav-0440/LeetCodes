class Solution {
    public boolean isSafe(char[][] board, int row, int col, int number) {
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char)(number + '0')) {
                return false;
            }
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == (char)(number + '0')) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char)(number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        // Base case: reached beyond last row
        if (row == 9) {
            return true;
        }

        int nrow, ncol;

        // Move to next cell
        if (col == 8) { // last column
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        // If the cell is already filled, move to next cell
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {
            // Try numbers 1–9
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char)(i + '0');
                    if (helper(board, nrow, ncol)) {
                        return true;
                    }
                    // Backtrack if not working
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}
