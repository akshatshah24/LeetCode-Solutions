class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int k = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    k = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][k--] = '#';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }
        return res;
    }
}