class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> map = new HashMap<>();

        for (int num1 : arr1) {
            String num1Str = Integer.toString(num1);
            String prefix = "";
            for (char ch : num1Str.toCharArray()) {
                prefix += ch;
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }

        int max = 0;

        for (int num2 : arr2) {
            String num2Str = String.valueOf(num2);
            String prefix = "";
            for (char ch : num2Str.toCharArray()) {
                prefix += ch;
                if (map.containsKey(prefix)) {
                    max = Math.max(max, prefix.length());
                }
            }
        }

        return max;
    }
}