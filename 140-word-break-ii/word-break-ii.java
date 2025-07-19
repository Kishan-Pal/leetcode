class TrieNode {
    char c;
    Map<Character, TrieNode> map;
    boolean isEnd;
    TrieNode() {
        this.c = ' ';
        this.map = new HashMap<>();
        this.isEnd = false;
    }
    TrieNode(char c) {
        this.c = c;
        this.map = new HashMap<>();
        this.isEnd = false;
    }

    public TrieNode add(char c) {
        if(this.map.containsKey(c)){
            return this.map.get(c);
        }
        TrieNode child = new TrieNode(c);
        this.map.put(c, child);
        return child;
    }
    public void add(String s) {
        TrieNode cur = this;
        for(int i=0; i<s.length(); i++) {
            cur = cur.add(s.charAt(i));
        }
        cur.isEnd = true;
    }
    public TrieNode get(char c) {
        return this.map.getOrDefault(c, null);
    }
}



class Solution {
    public static TrieNode root;
    public static List<String> list;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String i: wordDict) {
            root.add(i);
        }
        dfs(s, root, 0, sb);
        return list;
    }

    public void dfs(String s, TrieNode cur, int index, StringBuilder sb) {
        if(index == s.length()){
            list.add(sb.toString().strip());
        }
        sb.append(' ');
        for(int i=index; i<s.length(); i++) {
            cur = cur.get(s.charAt(i));
            if(cur == null) return;
            sb.append(s.charAt(i));
            if(cur.isEnd) {
                dfs(s, root, i+1, new StringBuilder(sb));
            }
        }
        return;
    }
}