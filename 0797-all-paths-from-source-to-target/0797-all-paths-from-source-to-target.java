class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>>[] dp = new List[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }
        
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(0);
        dp[0].add(initialPath);
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                indegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        if (indegree[0] == 0) {
            queue.offer(0);
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                for (List<Integer> path : dp[node]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    dp[neighbor].add(newPath);
                }
                
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return dp[n - 1];
    }
}
