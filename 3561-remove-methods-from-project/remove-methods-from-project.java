class Solution {
    private List<Integer>[] graph;
    private boolean[] suspicious;
    private boolean[] visited;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        suspicious = new boolean[n];
        visited = new boolean[n];

        markSuspicious(k);

        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (!suspicious[i] && reachesSuspicious(i)) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void markSuspicious(int node) {
        if (visited[node]) return;
        visited[node] = true;
        suspicious[node] = true;

        for (int next : graph[node]) {
            markSuspicious(next);
        }
    }

    private boolean reachesSuspicious(int node) {
        if (suspicious[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;

        for (int next : graph[node]) {
            if (reachesSuspicious(next)) {
                return true;
            }
        }

        return false;
    }
}