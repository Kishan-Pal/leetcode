class MyComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return (a.name).compareTo(b.name);
    }
}

class Node {
    String name;
    PriorityQueue<Node> list;
    Node(String name) {
        this.name = name;
        list = new PriorityQueue<>(new MyComparator());
    }

    public void add(Node node) {
        list.offer(node);
    }

    public Node getFirst() {
        return list.poll();
    }
}


class Solution {
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> map = new HashMap<>();
        res = new LinkedList<>();

        for(List<String> ticket: tickets) {
            String left = ticket.get(0), right = ticket.get(1);
            Node leftNode = null, rightNode = null;
            if(map.containsKey(left)) {
                leftNode = map.get(left);
            }
            else {
                leftNode = new Node(left);
                map.put(left, leftNode);
            }
            if(map.containsKey(right)) {
                rightNode = map.get(right);
            }
            else {
                rightNode = new Node(right);
                map.put(right, rightNode);
            }
            leftNode.add(rightNode);

        }
        

        dfs(map.get("JFK"));
        //printGraph(map);
        return res;
    }

    public void dfs(Node node) {
        while(!node.list.isEmpty()) {
            dfs(node.getFirst());
        }
        res.add(0, node.name);
    }

    // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    public void printGraph(Map<String, Node> map) {

        for(Map.Entry<String, Node> entry: map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(Node i: entry.getValue().list) {
                System.out.print(i.name + " ");
            }
            System.out.println();
        }
    }
}