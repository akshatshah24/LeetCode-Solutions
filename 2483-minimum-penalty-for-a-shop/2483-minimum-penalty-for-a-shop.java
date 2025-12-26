class Solution {
    public int bestClosingTime(String customers) {
        int maxScore = 0;
        int score = 0;
        int rightTime = -1;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                score++;
            } else {
                score--;
            }
            if (score > maxScore) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime + 1;
    }
}