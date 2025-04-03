class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long result = 0;

        long maxElement = 0, maxDiff = 0;

        for (int i = 0; i < n; i++) {            
            result = Math.max(result, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxElement - nums[i]);
            maxElement = Math.max(maxElement, nums[i]);
        }

        return result;
    }
}