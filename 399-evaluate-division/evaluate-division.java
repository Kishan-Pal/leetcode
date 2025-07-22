class Node {
    public String name;
    public List<Node> neighbors;
    public List<Double> distance;
    Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.distance = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor, Double distance) {
        this.neighbors.add(neighbor);
        this.distance.add(distance);
    }
}

class Solution {
    Map<String, Node> map;
    double[] res;
    int index;
    Set<String> visited;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        res = new double[queries.size()];
        index = 0;
        visited = new HashSet<>();
        for(int i=0; i<values.length; i++) {
            Node leftNode = map.computeIfAbsent(equations.get(i).get(0), k -> new Node(k));
            Node rightNode = map.computeIfAbsent(equations.get(i).get(1), k -> new Node(k));
            leftNode.addNeighbor(rightNode, values[i]);
            rightNode.addNeighbor(leftNode, 1/values[i]);
        }
        for(List<String> query: queries) {
            if(map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int returnVal = dfs(map.get(query.get(0)), query.get(1), 1.0);
                if(returnVal == 0) {
                    res[index++] = -1.0;
                }
            }
            else {
                res[index++] = -1.0;
            }
            
        }
       // displayNode();
        return res;
    }

    public int dfs(Node curNode, String target, Double curVal) {
        if(visited.contains(curNode.name)) return 0;
        if((curNode.name).equals(target)) {
            res[index++] = curVal;
            return -1;
        }
        visited.add(curNode.name);
        for(int i=0; i<(curNode.neighbors).size(); i++) {
            int returnVal = dfs(curNode.neighbors.get(i), target, curNode.distance.get(i) * curVal);
            if(returnVal == -1) {
                visited.remove(curNode.name);
                return -1;
            } 
        }
        visited.remove(curNode.name);
        return 0;
    }

    public void displayNode() {
        for(Map.Entry<String, Node> entry: map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            Node curNode = entry.getValue();
            for(Node neighbor: curNode.neighbors) {
                System.out.print(neighbor.name + " " );
            }
            System.out.println();
            System.out.print("d: ");
            for(Double i: curNode.distance) {
                System.out.print(i + " " );
            }
            System.out.println();
            System.out.println();
        }
    }
}