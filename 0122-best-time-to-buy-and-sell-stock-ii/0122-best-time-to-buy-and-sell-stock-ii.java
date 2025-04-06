class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 1][0], dp[i + 1][1]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];
    }
}