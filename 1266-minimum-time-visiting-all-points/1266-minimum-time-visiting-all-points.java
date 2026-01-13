class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i];
            int[] point2 = points[i + 1];
            int x1 = point1[0];
            int y1 = point1[1];
            int x2 = point2[0];
            int y2 = point2[1];
            int xDiff = Math.abs(x1 - x2);
            int yDiff = Math.abs(y1 - y2);
            time += Math.max(xDiff, yDiff);
        }
        return time;
    }
}