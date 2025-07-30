class Edge {
    int u;
    int v;
    int w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class Solution {
    int res = Integer.MIN_VALUE;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<Edge>[] graph = new ArrayList[values.length];
        for(int i=0; i<values.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));
        }
        int[] set = new int[1001];
        set[0] = 1;
        dfs(graph, values, 0, maxTime, 0, set);
        return res;
    }

    public void dfs(List<Edge>[] graph, int[] values, int u, int maxTime, int curTime, int[] set) {
        if(u == 0) {
            res = Math.max(res, getTotal(set, values));

        }
        set[u]++;
        for(Edge e: graph[u]) {
            if(curTime + e.w <= maxTime) {
                dfs(graph, values, e.v, maxTime, curTime + e.w, set);
            }
            
        }
        set[u]--;
    }

    public int getTotal(int[] set, int[] values) {
        int tempRes = 0;
        for(int i=0; i<set.length; i++) {
            if(set[i] > 0) {
                tempRes += values[i];
            }
        }
        return tempRes;
    }
}