class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        int n = operations.length;

        for (int i = 0; i < n; i++) {
            switch(operations[i]) {
                case "++X" : result++; break;
                case "X++" : result++; break;
                case "X--" : result--; break;
                case "--X" : result--; break;
                default: return 0;
            }
        }
        return result;
    }
}