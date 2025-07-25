class Node {
    String curName;
    Map<String, Node> children;
    boolean isEnd = false;
    Node(String name) {
        this.curName = name;
        children = new HashMap<>();
    }

    public Node add(String child) {
        this.children.computeIfAbsent(child, k -> new Node(child));
        return this.children.get(child);
    }

    public void addFull(String path) {
        Node cur = this;
        int left = 0;
        int n = path.length();
        for(int i=1; i<n; i++) {
            while(i<n && path.charAt(i) != '/') i++;
            cur = cur.add(path.substring(left, i));
            left = i;
            if(cur.isEnd) return;
        }
        cur.isEnd = true;
    }
}


class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node("");
        for(String s: folder) {
            root.addFull(s);
        }
        List<String> res = new ArrayList<>();
        dfs(root, res, new StringBuffer());
        return res;
    }

    public void dfs(Node cur, List<String> res, StringBuffer curRes) {
        if(cur.isEnd) {
            res.add(curRes.toString());
            return;
        }
        for(Map.Entry<String, Node> child: cur.children.entrySet()) {
            dfs(child.getValue(), res, new StringBuffer(curRes).append(child.getKey()));
        }
    }
}