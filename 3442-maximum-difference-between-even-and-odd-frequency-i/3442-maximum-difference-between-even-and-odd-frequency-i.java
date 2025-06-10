class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Integer maxOdd = null, minEven = null;

        for (int value : map.values()) {
            if (value % 2 == 0) {
                if (minEven == null || minEven > value) {
                    minEven = value;
                }
            } else {
                if (maxOdd == null || value > maxOdd) {
                    maxOdd = value;
                }
            }
        }

        if (maxOdd != null && minEven != null) {
            return maxOdd - minEven;
        }

        return -1;
    }
}