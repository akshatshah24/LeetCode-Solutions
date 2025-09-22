class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i : map.values()) {
            max = Math.max(max, i);
        }

        for (int i : map.values()) {
            if (max == i) {
                maxFreq += i;
            }
        }
        return maxFreq;
    }
}