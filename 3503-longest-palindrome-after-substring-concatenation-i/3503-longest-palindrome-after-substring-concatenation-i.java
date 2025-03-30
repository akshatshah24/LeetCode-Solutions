class Solution {
    public int longestPalindrome(String s, String t) {
        List<String> s1 = new ArrayList<>();
        List<String> t1 = new ArrayList<>();

        generateSubstrings(s, s1);
        generateSubstrings(t, t1);

        Set<String> concats = new HashSet<>();

        int n = s1.size(), m = t1.size();

        concats.addAll(s1);
        concats.addAll(t1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // concats.
                concats.add(s1.get(i).concat(t1.get(j)));
            }
        }

        int max = Integer.MIN_VALUE;

        for (String str : concats) {
            if (isPalindrome(str)) {
                max = Math.max(max, str.length());
            }
        }

        return max;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void generateSubstrings(String s, List<String> subs) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                subs.add(s.substring(i, j + 1));
            }
        }
    }
}