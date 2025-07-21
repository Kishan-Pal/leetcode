class Solution {
    private List<List<Integer>> graph;
    private Set<Integer> visitedSet;
    private Set<Integer> visitingSet;
    private int[] res;
    private int counter;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        counter = 0;
        graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        visitedSet = new HashSet<>();
        visitingSet = new HashSet<>();

        for(int i=0; i<numCourses; i++) {
            if(!visitedSet.contains(i)) {
                int r = dfs(i);
                if(r == -1) return new int[0];
            }
        }
        return res;
    }
    public int dfs(int i) {
        if(visitingSet.contains(i)) return -1;
        if(visitedSet.contains(i)) return 0;
        visitingSet.add(i);
        visitedSet.add(i);
        for(int neighbor: graph.get(i)) {
            int r = dfs(neighbor);
            if(r == -1) return r;
        }
        visitingSet.remove(i);
        res[counter++] = i;
        return 0;
    }
}