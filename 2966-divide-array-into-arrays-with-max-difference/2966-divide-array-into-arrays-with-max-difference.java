class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int i = 0;
   
    
        if (nums.length % 3 != 0) {
            return new int[0][0] ;
        }

        int[][] arr = new int[nums.length / 3][3];

        while (i + 3 <= nums.length) {
            if (Math.abs(nums[i] - nums[i + 2]) > k) {
                return new int[0][0];
            }
            i = i + 3;
        }


        for (int j = 0; j < arr.length; j++) {
            System.arraycopy(nums, j * 3, arr[j], 0, 3);
        }

        return arr;
    }
}