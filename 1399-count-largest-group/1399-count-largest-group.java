class Solution {
    public int countLargestGroup(int n) {
        int result = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            map.computeIfAbsent(digitSum, k -> new ArrayList<>());
            map.get(digitSum).add(i);
        }

        int max = 0;
        for (List<Integer> value : map.values()) {
            if (max < value.size()) {
                max = value.size();
            }
        }

        for (List<Integer> value : map.values()) {
            if (max == value.size()) {
                result++;
            }
        }

        return result;
    }

    public int getDigitSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }

        return sum;
    }
}