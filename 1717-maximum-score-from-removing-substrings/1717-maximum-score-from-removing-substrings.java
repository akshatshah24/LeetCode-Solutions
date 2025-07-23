class Solution {
    public int maximumGain(String s, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int score = 0;
        char first = 'a';
        char second = 'b';
        if (x < y) {
            first = 'b';
            second = 'a';
            int temp = x;
            x = y;
            y = temp;
        }
        for (char c : s.toCharArray()) {
            if (c == first) {
                aCount++;
            } else if (c == second) {
                if (aCount > 0) {
                    aCount--;
                    score += x;
                } else {
                    bCount++;
                }
            } else {
                score += Math.min(aCount, bCount) * y;
                aCount = 0;
                bCount = 0;
            }
        }
        score += Math.min(aCount, bCount) * y;
        return score;
    }
}