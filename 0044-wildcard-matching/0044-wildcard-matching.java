class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        int[] prev = new int[m + 1];

        prev[0] = 1;

        // for (int i = 1; i <= n; i++) {
        //     dp[i][0] = 0;
        // }

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*' && prev[j - 1] == 1) {
                prev[j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {

            int[] curr = new int[m + 1];
            curr[0] = 0;

            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] | curr[j - 1];
                } else {
                    curr[j] = 0;
                }
            }

            prev = curr;
        }

        return prev[m] == 1;
    }

    public int isAllStars(String s, int k) {
        for (int j = 1; j <= k; j++) {
            if (s.charAt(j - 1) != '*') {
                return 0;
            }
        }

        return 1;
    }
}