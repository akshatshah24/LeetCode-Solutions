class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int sum = 0, maxSum = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, nums[i]);

            if (nums[i] <= 0 || set.contains(nums[i])) {
                continue;
            }

            sum += nums[i];
            set.add(nums[i]);
        }

        return maxSum <= 0 ? maxSum : sum;
    }
}