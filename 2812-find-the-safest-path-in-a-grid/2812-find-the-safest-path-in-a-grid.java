class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = getDistToThief(grid);
        int l = 0, r = grid.size() * 2;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canReachEnd(distToThief, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l - 1;
    }

    private boolean canReachEnd(int[][] distToThief, int maxDist) {
        int n = distToThief.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (distToThief[x][y] < maxDist) {
                continue;
            }

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    private int[][] getDistToThief(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distToThief = new int[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                distToThief[i][j] = grid.get(i).get(j) == 1 ? 0 : Integer.MAX_VALUE;
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        for (int dist = 0; !queue.isEmpty(); dist++) {
            for (int size = queue.size(); size > 0; size--) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                distToThief[x][y] = dist;

                for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return distToThief;
    }
}