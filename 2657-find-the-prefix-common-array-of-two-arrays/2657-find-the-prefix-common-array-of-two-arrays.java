class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] pos = new int[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            pos[A[i]] += 1;
            if (pos[A[i]] == 2) {
                commonCount++;
            }

            pos[B[i]] += 1;
            if (pos[B[i]] == 2) {
                commonCount++;
            }

            C[i] = commonCount;
        }
        
        return C;
    }
}