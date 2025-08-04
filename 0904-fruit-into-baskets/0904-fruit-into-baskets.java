class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int i = 0;
        int j = 0;
        int[] count = new int[fruits.length];
        int types = 0;
        while (j < fruits.length) {
            if (count[fruits[j]] == 0) {
                types++;
            }
            count[fruits[j]]++;
            while (types > 2) {
                count[fruits[i]]--;
                if (count[fruits[i]] == 0) {
                    types--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}