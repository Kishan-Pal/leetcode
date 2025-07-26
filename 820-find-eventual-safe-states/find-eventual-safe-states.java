class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] isSafe = new boolean[n];
        for(int i=0; i<n; i++) {
            if(graph[i].length == 0) {
                isSafe[i] = true;
            }
        }
        for(int i=0; i<n; i++) {
            if(!isSafe[i]) {
                boolean[] visited = new boolean[n];
                dfs(i, graph, visited, isSafe);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(isSafe[i]) res.add(i);
        }
        return res;
    }

    public boolean dfs(int cur, int[][] graph, boolean[] visited, boolean[] isSafe) {
        if(isSafe[cur]) return true;
        if(visited[cur]) return false;
        visited[cur] = true;
        boolean curRes = true;
        for(int neighbor: graph[cur]) {
            curRes = curRes && dfs(neighbor, graph, visited, isSafe);
            if(!curRes) return false;

        }
        if(curRes == true) {
            isSafe[cur] = true;
            return true;
        }
        return false;

    }
}