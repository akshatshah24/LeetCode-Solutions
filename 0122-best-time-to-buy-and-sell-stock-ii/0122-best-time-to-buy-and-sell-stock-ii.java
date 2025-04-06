class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(prices, 0, 1, dp);
    }

    public int dfs(int[] prices, int index, int buy, int[][] dp) {
        if (index == prices.length) return 0;

        if (dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[index] + dfs(prices, index + 1, 0, dp), dfs(prices, index + 1, 1, dp));
        } else {
            profit = Math.max(prices[index] + dfs(prices, index + 1, 1, dp), dfs(prices, index + 1, 0, dp));
        }

        return dp[index][buy] = profit;
    }
}