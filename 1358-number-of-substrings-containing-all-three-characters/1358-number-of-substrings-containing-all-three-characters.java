class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.getOrDefault('a', 0) > 0 && 
                    map.getOrDefault('b', 0) > 0 && 
                    map.getOrDefault('c', 0) > 0) {
                        count += n - i;
                        c = s.charAt(left);
                        map.put(c, map.get(c) - 1);
                        left++;
            }
        }
        
        return count;
    }
}