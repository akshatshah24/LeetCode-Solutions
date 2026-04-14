class Solution {

    Long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        int n = robot.size();
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        dp = new Long[n + 1][factory.length + 1];

        return dfs(robot, factory, 0, 0);
    }

    private long dfs(List<Integer> robot, int[][] factory, int i, int j) {
        if (i >= robot.size()) {
            return 0;
        }
        if (j >= factory.length) {
            return Long.MAX_VALUE;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long x = 0;
        long ans = dfs(robot, factory, i, j + 1);

        for (int k = i; k < robot.size() && k - i + 1 <= factory[j][1]; k++) {
            x += Math.abs(robot.get(k) - factory[j][0]);
            long p = dfs(robot, factory, k + 1, j + 1);

            if (p != Long.MAX_VALUE) {
                ans = Math.min(ans, x + p);
            }
        }

        return dp[i][j] = ans;
    }
}