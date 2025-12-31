class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col, latestPossibleDay = 0;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, mid, cells)) {
                left = mid;
                latestPossibleDay = mid;
            } else {
                right = mid;
            }
        }
        return latestPossibleDay;
    }

    private boolean canCross(int row, int col, int day, int[][] cells) {
        int[][] grid = new int[row + 1][col + 1];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < day; i++) {
            grid[cells[i][0]][cells[i][1]] = 1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int j = 1; j <= col; j++) {
            if (grid[1][j] == 0) {
                queue.offer(new int[]{1, j});
                grid[1][j] = 1;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0], currCol = curr[1];
            if (currRow == row) {
                return true;
            }
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (nextRow >= 1 && nextRow <= row && nextCol >= 1 && nextCol <= col && grid[nextRow][nextCol] == 0) {
                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = 1;
                }
            }
        }
        return false;
    }
}