class ThroneInheritance {
    class Node {
        String name;
        List<Node> children;
        boolean isDead;
        Node(String name) {
            this.name = name;
            children = new ArrayList<>();
            isDead = false;
        }
        public void kill() {
            this.isDead = true;
        }
    }

    Node king;
    static Map<String, Node> map = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.king = new Node(kingName);
        map.put(kingName, this.king);
    }
    
    public void birth(String parentName, String childName) {
        Node child = new Node(childName);
        Node parent = map.get(parentName);
        parent.children.add(child);
        map.put(childName, child);
    }
    
    public void death(String name) {
        Node cur = map.get(name);
        cur.kill();
    }
    
    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        getInheritance(king, inheritanceOrder);
        return inheritanceOrder;
    }

    public void getInheritance(Node cur, List<String> inheritanceOrder) {
        if(!cur.isDead) {
            inheritanceOrder.add(cur.name);
        }
        for(Node child: cur.children) {
            getInheritance(child, inheritanceOrder);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */