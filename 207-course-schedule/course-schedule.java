class Node {
    public int id;
    public List<Node> list;
    Node() {
        this.id = 0;
        this.list = new ArrayList<>();
    }
    Node(int id) {
        this.id = id;
        this.list = new ArrayList<>();
    }
    Node(int id, List<Node> list) {
        this.id = id;
        this.list = list;
    }
}

class Solution {
    public Map<Integer, Node> map;
    public Set<Integer> visiting;
    public Set<Integer> visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();

        // Create the graph
        for (int[] link : prerequisites) {
            Node from = map.computeIfAbsent(link[0], k -> new Node(k));
            Node to = map.computeIfAbsent(link[1], k -> new Node(k));
            from.list.add(to);
        }

        visiting = new HashSet<>();
        visited = new HashSet<>();

       
        for (int i = 0; i < numCourses; i++) {
            Node node = map.getOrDefault(i, new Node(i)); 
            map.putIfAbsent(i, node); 
            if (!visited.contains(i)) {
                if (dfs(node)) return false;
            }
        }
        return true;
    }

    private boolean dfs(Node node) {
        if (visiting.contains(node.id)) return true; 
        if (visited.contains(node.id)) return false; 

        visiting.add(node.id);

        for (Node neighbor : node.list) {
            if (dfs(neighbor)) return true;
        }

        visiting.remove(node.id);
        visited.add(node.id);
        return false;
    }
}
