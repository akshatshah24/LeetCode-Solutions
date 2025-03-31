class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length - 1;
        long[] prefixSum = new long[n];
        long sum = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(prefixSum);
        for (int i = 0; i < k - 1; i++) {
            sum += prefixSum[n - i - 1] - prefixSum[i];
        }
        return sum;
    }
}