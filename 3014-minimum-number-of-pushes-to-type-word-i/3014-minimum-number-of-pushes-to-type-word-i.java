class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int key = 2;

        for (int i = 0; i < word.length(); i++) {
            if (key > 9) {
                key = 2;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            ans += map.get(key);
            key++;
        }
        return ans;
    }
}