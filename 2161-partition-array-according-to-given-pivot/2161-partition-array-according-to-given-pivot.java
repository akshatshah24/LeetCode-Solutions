class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                equal.add(nums[i]);
            } else if (nums[i] < pivot) {
                small.add(nums[i]);
            } else {
                large.add(nums[i]);
            }
        }

        int[] result = new int[n];

        small.addAll(equal);
        small.addAll(large);

        for (int i = 0; i < n; i++) {
            result[i] = small.get(i);
        }

        return result;
    }
}