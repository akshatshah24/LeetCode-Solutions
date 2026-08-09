class Solution {
    public int stoneGameII(int[] piles) {
        int[] presum = Arrays.copyOf(piles, piles.length);
        for (int i = presum.length - 2; i >= 0; i--) {
            presum[i] += presum[i + 1];
        }
        return dfs(piles, presum, 0, 1, new int[piles.length][piles.length]);
    }

    private int dfs(int[] piles, int[] presum, int start, int M, int[][] memo) {
        if (start >= piles.length) {
            return 0;
        }
        if (start + 2 * M >= piles.length) {
            return presum[start];
        }
        if (memo[start][M] != 0) {
            return memo[start][M];
        }
        int max = 0;
        for (int i = 1; i <= 2 * M; i++) {
            max = Math.max(max, presum[start] - dfs(piles, presum, start + i, Math.max(M, i), memo));
        }
        memo[start][M] = max;
        return max;
    }
}