class TrieNode {
    char c;
    Map<Character, TrieNode> map;
    boolean isEnd;
    TrieNode() {
        c = ' ';
        map = new HashMap<>();
        isEnd = false;
    }
    TrieNode(char c) {
        this.c = c;
        map = new HashMap<>();
        isEnd = false;
    }

    public TrieNode add(char c) {
        if(this.map.containsKey(c)) {
            return this.map.get(c);
        }
        TrieNode child = new TrieNode(c);
        this.map.put(c, child);
        return child;
    }

    public void add(String s) {
        TrieNode childNode = this;
        for(int i=0; i<s.length(); i++) {
            childNode = childNode.add(s.charAt(i));
        }
        childNode.isEnd = true;
    }
    public TrieNode get(char c) {
        if(this.map.containsKey(c)) {
            return this.map.get(c);
        }
        return null;
    }
}

class Solution {


    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] canEnd = new boolean[n+1];
        canEnd[0] = true;
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for(String i: wordDict) {
            root.add(i);
        }
        for(int i=1; i<=n && !canEnd[n]; i++) {
            if(canEnd[i-1]) {
                cur = root;
                for(int j=i-1; j<n; j++) {
                    cur = cur.get(s.charAt(j));
                    if(cur == null) break;
                    if(cur.isEnd) canEnd[j+1] = true;
                }
            }
        }
        return canEnd[n];
    }
}