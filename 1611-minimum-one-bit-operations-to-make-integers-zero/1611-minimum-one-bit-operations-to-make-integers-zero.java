class Solution {
    public int minimumOneBitOperations(int n) {
        int multiplier = 1;
        int result = 0;
        while (n > 0) {
            result += n ^ (n - 1) * multiplier;
            multiplier = -1 * multiplier;
            n &= n - 1;
        }
        return Math.abs(result);
    }
}