class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // set1.add(0);
        List<Integer> shouldVisit = new ArrayList<>();
        // shouldVisit.add(0);
        boolean[] visited = new boolean[graph.length];
        for(int h=0; h<visited.length; h++) {
            if(!visited[h]) {
                visited[h] = true;
                set1.add(h);
                shouldVisit.add(h);

                for(int i=0; i<shouldVisit.size(); i++) {
                    int curNode = shouldVisit.get(i);

                    if(set1.contains(curNode)) {
                        for(int v: graph[curNode]) {
                            if(set1.contains(v)) return false;
                            if(!set2.contains(v)) {
                                set2.add(v);
                                shouldVisit.add(v);
                                visited[v] = true;
                            }
                        }

                    }
                    else if(set2.contains(curNode)) {
                        for(int v: graph[curNode]) {
                            if(set2.contains(v)) return false;
                            if(!set1.contains(v)) {
                                set1.add(v);
                                shouldVisit.add(v);
                                visited[v] = true;
                            }
                        }

                    }
                }



            }
        }
        
        return true;
    }
}