/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private static Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        map = new HashMap<>();
        Node node2 = new Node(node.val);
        map.put(node.val, node2);
        dfs(node, node2);
        return node2;
    }

    public void dfs(Node original, Node copy) {
        for(Node neighbor: original.neighbors) {
            if(map.containsKey(neighbor.val)){
                copy.neighbors.add(map.get(neighbor.val));
                continue;
            }
            Node newNeighbor = new Node(neighbor.val);
            copy.neighbors.add(newNeighbor);
            map.put(neighbor.val, newNeighbor);
            dfs(neighbor, newNeighbor);
        }
    }
}