class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. check row
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        // 2. check column
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        // 3. check sub-box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    int row = i + k / 3;
                    int col = j + k % 3;
                    if (board[row][col] != '.' && !set.add(board[row][col])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}