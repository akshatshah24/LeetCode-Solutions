class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (events[mid][1] < events[i - 1][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[l][j - 1] + events[i - 1][2]);
            }
        }
        return dp[n][k];
    }
}