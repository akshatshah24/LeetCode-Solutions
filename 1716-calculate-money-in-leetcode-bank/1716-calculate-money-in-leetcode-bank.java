class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int week = 0;
        int day = 0;
        for (int i = 0; i < n; i++) {
            day++;
            total += week + day;
            if (day == 7) {
                week++;
                day = 0;
            }
        }
        return total;
    }
}