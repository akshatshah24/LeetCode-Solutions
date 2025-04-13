class Solution {
    private final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long result = (power(5, even) * power(4, odd)) % MOD;

        return (int) result;
    }

    public long power(long n, long num) {
        long result = 1;
        while (num > 0) {
            if (num % 2 == 1)
                result = (result * n) % MOD;
            n = (n * n) % MOD;
            num /= 2;
        }
        return result;
    }
}