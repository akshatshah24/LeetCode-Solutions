class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += Math.abs(num);
                if (num < 0) {
                    count++;
                }
                min = Math.min(min, Math.abs(num));
            }
        }
        return count % 2 == 0 ? sum : sum - 2 * min;
    }
}