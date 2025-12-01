class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int i : batteries) {
            sum += i;
        }
        int left = 0;
        int right = batteries.length;
        while (batteries[right - 1 - left] > sum / (n - left)) {
            sum -= batteries[right - 1 - left++];
        }
        return sum / (n - left);
    }
}