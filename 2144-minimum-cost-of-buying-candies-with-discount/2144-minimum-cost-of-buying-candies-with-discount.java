class Solution {
    public int minimumCost(int[] A) {
        // Step 1: Sort the array so that cheaper candies come first
       Arrays.sort(A);

       // Step 2: Initialize result and get length of array
        int res = 0, n = A.length;

        // Step 3: Traverse through all candies
        for (int i = 0; i < n; i++){
        // Condition: skip every 3rd candy (the free one)
            // n % 3 ensures alignment with array length
            if (i % 3 != n % 3){
            // Add cost of candy if it's not the free one
                res += A[i];
            }
        }
        // Step 4: Return the total minimum cost
        return res;
    }
}