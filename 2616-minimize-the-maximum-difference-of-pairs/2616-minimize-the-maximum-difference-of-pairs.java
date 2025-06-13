class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int i = 1; i < n && count < p; i++) {
                if (nums[i] - nums[i-1] <= mid) {
                    count++;
                    i++;
                }
            }
            if (count >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}