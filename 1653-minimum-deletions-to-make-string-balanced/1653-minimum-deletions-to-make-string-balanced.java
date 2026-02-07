class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length() + 1];
        int index = 1;
        int bCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                dp[index] = Math.min(dp[index - 1] + 1, bCount);
            } else {
                dp[index] = dp[index - 1];
                bCount++;
            }
            index++;
        }

        return dp[s.length()];
    }
}