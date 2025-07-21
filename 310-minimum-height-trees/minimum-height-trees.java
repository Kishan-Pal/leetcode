class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new HashSet<Integer>());
            nodes.add(i);
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // for(Set<Integer> a: graph) {
        //     for(int i: a) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }

        List<Integer> leaves = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
                // System.out.println("added " + i);
            }
        }

        while(nodes.size() > 2) {

            for(int leaf: leaves) {
                int neighbor = -1;
                Set<Integer> curSet = graph.get(leaf);
                for(int j: curSet) {
                    neighbor = j;
                }
                // System.out.println("removed " + leaf);
                graph.get(neighbor).remove(leaf);
                curSet.remove(neighbor);
                nodes.remove(leaf);
            }
            leaves.clear();
            for(int i=0; i<n; i++) {
                if(graph.get(i).size() == 1) {
                    leaves.add(i);
                    // System.out.println("added " + i);
                }                
            }
            // System.out.println("Graph: ");
            // for(Set<Integer> a: graph) {
            //     for(int i: a) {
            //         System.out.print(i + " ");
            //     }
            //     System.out.println();
            // }

        }

        leaves = new ArrayList<>(nodes);
        return leaves;

    }
}