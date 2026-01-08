class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums1, nums2, 0, 0, memo);
    }

    private int dfs(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        if (i == nums1.length || j == nums2.length) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums1[i] * nums2[j] +
                Math.max(dfs(nums1, nums2, i + 1, j + 1, memo), 0),
                Math.max(dfs(nums1, nums2, i + 1, j, memo),
                        dfs(nums1, nums2, i, j + 1, memo)));
        return memo[i][j];
    }
}