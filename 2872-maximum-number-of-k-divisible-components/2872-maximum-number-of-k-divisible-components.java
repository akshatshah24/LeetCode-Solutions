class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int[] result = new int[1];

        dfs(0, -1, adjList, result, values, k);

        return result[0];
    }

    public int dfs(int curr, int parent, List<Integer>[] adjList, int[] result, int[] values, int k) {
        int total = values[curr];
        total %= k;

        for (int child : adjList[curr]) {
            if (child != parent) {
                total += dfs(child, curr, adjList, result, values, k);
                total %= k;
            }
        }

        if (total % k == 0) {
            result[0]++;
        }
        return total;
    }
}