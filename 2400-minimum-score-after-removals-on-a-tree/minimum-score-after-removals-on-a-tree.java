class Solution {
    Set<Integer>[] descendents;
    List<Integer>[] graph;
    int[] subTreeXor;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        subTreeXor = new int[n];
        descendents = new HashSet[n];
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
            descendents[i] = new HashSet<>();
        }
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(nums, 0, -1);
        int res = Integer.MAX_VALUE;
        for(int i=1; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int xori = subTreeXor[i];
                int xorj = subTreeXor[j];
                int xorRoot = subTreeXor[0];
                if(descendents[i].contains(j)) { // j is descendent of i
                    xorRoot ^= xori;
                    xori ^= xorj;
                }
                else if(descendents[j].contains(i)) {
                    xorRoot ^= xorj;
                    xorj^= xori;
                }
                else {
                    xorRoot ^= xori ^ xorj;
                }
                int min = Math.min(xorRoot, Math.min(xori, xorj));
                int max = Math.max(xorRoot, Math.max(xori, xorj));
                res = Math.min(res, max-min);
            }
        }
        return res;
        // for(int i=0; i<subTreeXor.length; i++) {
        //     System.out.println(i + ": " + subTreeXor[i]);
        // }
        // return 0;
    }

    public void dfs(int[] nums, int cur, int parent) {
        subTreeXor[cur] = nums[cur];
        descendents[cur].add(cur);

        for(int neighbor: graph[cur]) {
            if(neighbor != parent) {
                dfs(nums, neighbor, cur);
                subTreeXor[cur] ^= subTreeXor[neighbor];
                descendents[cur].addAll(descendents[neighbor]);
            }
        }

    }
}