class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int dec = 0;
        long sum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            sum += Math.max(0, happiness[i] - dec);
            dec++;
        }
        return sum;
    }
}