class Solution {
    public int numSteps(String s) {
        int steps = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length() - 1) == '0') {
                s = s.substring(0, s.length() - 1);
            } else {
                s = addOne(s);
            }
            steps++;
        }
        return steps;
    }

    private String addOne(String s) {
        StringBuilder sb = new StringBuilder();
        boolean carry = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (carry) {
                if (s.charAt(i) == '1') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                    carry = false;
                }
            } else {
                sb.insert(0, s.charAt(i));
            }
        }
        if (carry) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}