class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }

        int count = 0;
        for (int i = 0; i < (1 << n); i++) {
            int or = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    or |= nums[j];
                }
            }
            if (or == maxOr) {
                count++;
            }
        }

        return count;
    }
}
