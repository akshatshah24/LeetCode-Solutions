class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] c = maxHeap.poll();
            double gain = c[0];
            double pass = c[1];
            double total = c[2];
            pass++;
            total++;
            gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        double sum = 0;
        while (!maxHeap.isEmpty()) {
            double[] c = maxHeap.poll();
            double pass = c[1];
            double total = c[2];
            sum += pass / total;
        }

        return sum / classes.length;
    }

    private double calculateGain(double pass, double total) {
        return (
                (double) (pass + 1) / (total + 1) -
                (double) pass / total
                );
    }
}
