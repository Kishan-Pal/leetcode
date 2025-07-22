class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        Disjoint ds = new Disjoint(edges.length+1);
        for(int[] edge: edges) {
            if(!ds.union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{0, 0};
    }
}

class Disjoint {
    int[] parent;
    int[] rank;
    Disjoint(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    private int find(int i) {
        if(parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    public boolean union(int u, int v) {
        int parentu = find(u);
        int parentv = find(v);

        if(parentu == parentv) return false;

        if(rank[parentu] > rank[parentv]) {
            parent[parentv] = parentu;
        }
        else if(rank[parentv] > rank[parentu]) {
            parent[parentu] = parentv;
        }
        else {
            parent[parentu] = parentv;
            rank[parentv]++;
        }
        return true;
    }
}