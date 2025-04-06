class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][3];

        for (int[][] arr : dp) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }

        return dfs(prices, 0, 1, 2, dp);
    }

    public int dfs(int[] prices, int index, int buy, int capacity, int[][][] dp) {
        if (index == prices.length || capacity == 0) return 0;

        if (dp[index][buy][capacity] != -1) return dp[index][buy][capacity];
        
        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[index] + dfs(prices, index + 1, 0, capacity, dp), dfs(prices,index + 1, 1, capacity, dp));
        } else {
            profit = Math.max(prices[index] + dfs(prices, index + 1, 1, capacity - 1, dp), dfs(prices, index + 1, 0, capacity, dp));
        }

        return dp[index][buy][capacity] = profit;
    }
}