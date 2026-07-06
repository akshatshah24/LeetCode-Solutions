import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start point ascending. If start points are equal, sort by end point descending.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        int remainingCount = 0;
        int maxEnd = 0;
        
        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            // If the current end is greater than the max end seen so far, it is NOT covered.
            if (currentEnd > maxEnd) {
                remainingCount++;
                maxEnd = currentEnd;
            }
        }
        
        return remainingCount;
    }
}