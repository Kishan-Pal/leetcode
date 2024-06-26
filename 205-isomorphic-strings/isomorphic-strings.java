class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        int n = s.length();
        int j=0, k=0;
        int[] is = new int[n];
        int[] it = new int[n];
        for(int i=0; i<n; i++) {
            char c1 = s.charAt(i);
            if(!hs.containsKey(c1)) {
                hs.put(c1, j);
                j = j + 1;
            }
            is[i] = hs.get(c1);
            char c2 = t.charAt(i);
            if(!ht.containsKey(c2)){
                ht.put(c2, k);
                k = k + 1;
            }
            it[i] = ht.get(c2);
            //System.out.println(is[i] + " " + it[i]);
            if(is[i] != it[i]) return false;
        }
        return true;
    }
}