class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        n = n + 1; // Adjusting for 1-based indexing
        int[][] graph = new int[n][n];
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                graph[i][j] = Integer.MAX_VALUE;

            }
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u][v] = w;
        }

        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        for (int i = 1; i < n; i++) {
            int mini = -1;
            int mind = Integer.MAX_VALUE;

            // Find the unvisited node with the smallest distance
            for (int j = 1; j < n; j++) {
                if (!visited[j] && distances[j] < mind) {
                    mind = distances[j];
                    mini = j;
                }
            }

            if (mini == -1) break; // All remaining nodes are unreachable

            visited[mini] = true;

            for (int v = 1; v < n; v++) {
                if (graph[mini][v] != Integer.MAX_VALUE && !visited[v]) {
                    distances[v] = Math.min(distances[v], distances[mini] + graph[mini][v]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (distances[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distances[i]);
        }

        return res;
    }
}
