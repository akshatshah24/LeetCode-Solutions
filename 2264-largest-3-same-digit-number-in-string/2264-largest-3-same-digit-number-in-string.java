class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int ans = -1;
        for (int i = 0; i + 2 < n; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                ans = Math.max(ans, num.charAt(i) - '0');
            }
        }
        StringBuilder sb = new StringBuilder(3);
        if (ans == -1) {
            return "";
        } else {
            sb.append(ans);
            sb.append(ans);
            sb.append(ans);
            return sb.toString();
        }
    }
}