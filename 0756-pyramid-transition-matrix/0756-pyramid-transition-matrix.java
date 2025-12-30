class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] T = new int[1 << 7][1 << 7];
        for (String triple: allowed) {
            int u = 1 << (triple.charAt(0) - 'A');
            int v = 1 << (triple.charAt(1) - 'A');
            int w = 1 << (triple.charAt(2) - 'A');
            for (int b1 = 0; b1 < (1 << 7); ++b1) if ((u & b1) > 0)
                for (int b2 = 0; b2 < (1 << 7); ++b2) if ((v & b2) > 0)
                    T[b1][b2] |= w;
        }

        int[] state = new int[bottom.length()];
        int t = 0;
        for (char c: bottom.toCharArray())
            state[t++] = 1 << (c - 'A');
        while (t-- > 1)
            for (int i = 0; i < t; ++i)
                state[i] = T[state[i]][state[i+1]];
        return state[0] > 0;
    }
}