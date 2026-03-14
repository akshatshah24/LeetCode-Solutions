class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();

        generateHappyStrings(n, happyStrings, "");

        if (happyStrings.size() < k) return "";

        Collections.sort(happyStrings);

        return happyStrings.get(k - 1);
    }

    public void generateHappyStrings(int n, List<String> list, String str) {
        if (str.length() == n) {
            list.add(str);
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == c) {
                continue;
            }
            generateHappyStrings(n, list, str + c);
        }
    }
}