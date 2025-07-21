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
    public Map<Integer, Boolean> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for(int[] link: prerequisites) {
            Node left, right;
            if(map.containsKey(link[0])) {
                left = map.get(link[0]);
            }
            else {
                left = new Node(link[0]);
                map.put(link[0], left);
            }
            if(map.containsKey(link[1])) {
                right = map.get(link[1]);
            }
            else {
                right = new Node(link[1]);
                map.put(link[1], right);
            }
            left.list.add(right);
        }
        visited = new HashMap<>();
        for(Map.Entry<Integer, Node> entry: map.entrySet()) {
            if(!visited.containsKey(entry.getKey())) {
                int res = dfs(entry.getValue());
                if(res == -1) return false;
            }
        }
        return true;
    }
    public int dfs(Node cur) {
        if(cur == null) return 0;
        if(!visited.containsKey(cur.id)) {
            visited.put(cur.id, true);
        }
        else if(visited.get(cur.id) == true) return -1;
        else return 0;
        visited.put(cur.id, true);
        for(Node neighbor: cur.list) {
            if(neighbor == null) continue;
            int res = dfs(neighbor);
            if(res == -1) return -1;
        }
        visited.put(cur.id, false);
        return 0;

    }
}