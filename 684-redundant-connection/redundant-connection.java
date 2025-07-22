class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] graph = new ArrayList[edges.length+1];

        for(int i=0; i<edges.length+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            boolean[] visited = new boolean[edges.length+1];
            if(dfs(graph, node1, node2, visited)) {
                return new int[]{node1, node2};
            }

            graph[node1].add(node2);
            graph[node2].add(node1);

        }
        return new int[]{0, 0};
    }

    public boolean dfs(List<Integer>[] graph, int src, int dst, boolean[] visited) {
        if(visited[src]) return false;
        if(src == dst) return true;
        visited[src] = true;
        for(int i: graph[src]) {
            if(dfs(graph, i, dst, visited)) {
                return true;
            }
        }
        return false;
    }
}