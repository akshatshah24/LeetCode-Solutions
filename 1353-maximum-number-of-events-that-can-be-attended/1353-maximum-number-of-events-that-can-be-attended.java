class Solution {
    public int maxEvents(int[][] events) {
        int maxCount = 0;


        Map<Integer, List<Integer>> map = new HashMap<>();
        int earliestStart = Integer.MAX_VALUE;
        int latestEnd = 0;


        for (int i = 0; i < events.length; i++) {
            int start = events[i][0];
            int end = events[i][1];

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(end);

            earliestStart = Math.min(earliestStart, start);
            latestEnd = Math.max(latestEnd, end);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = earliestStart; i <= latestEnd; i++) {
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }

            for (int endDay : map.getOrDefault(i, Collections.emptyList())) {
                pq.offer(endDay);
            }

            if (!pq.isEmpty()) {
                pq.poll();
                maxCount++;
            }
        }

        return maxCount;
    }
}