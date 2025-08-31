class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (dfs(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == k || board[l][j] == k) {
                return false;
            }
        }

        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;

        for (int a = startRow; a < startRow + 3; a++) {
            for (int b = startCol; b < startCol + 3; b++) {
                if (board[a][b] == k) {
                    return false;
                }
            }
        }

        return true;
    }
}