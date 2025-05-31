class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];
        int idx = 1;
        boolean isReverse = false;
        for (int i = n - 1; i >= 0; i--) {
            if (isReverse) {
                for (int j = n - 1; j >= 0; j--) {
                    arr[idx++] = board[i][j];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    arr[idx++] = board[i][j];
                }
            }
            isReverse = !isReverse;
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > n * n) {
                    break;
                }
                if (arr[next] != -1) {
                    next = arr[next];
                }
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return dist[n * n];
    }
}