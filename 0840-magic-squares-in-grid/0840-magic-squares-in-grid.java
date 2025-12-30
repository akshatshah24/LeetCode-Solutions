class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagic(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        if (grid[r + 1][c + 1] != 5) {
            return false;
        }
        int[] count = new int[16];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                count[grid[i][j]]++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        if (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] != 15) {
            return false;
        }
        if (grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] != 15) {
            return false;
        }
        if (grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] != 15) {
            return false;
        }
        if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] != 15) {
            return false;
        }
        if (grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] != 15) {
            return false;
        }
        if (grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] != 15) {
            return false;
        }
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != 15) {
            return false;
        }
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != 15) {
            return false;
        }
        return true;
    }
}