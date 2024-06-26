class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        int n = s.length();
        int j=0, k=0, temp1, temp2;
        for(int i=0; i<n; i++) {
            char c1 = s.charAt(i);
            hs.put(c1, hs.getOrDefault(c1, j++));
            temp1 = hs.get(c1);
            char c2 = t.charAt(i);
            ht.put(c2, ht.getOrDefault(c2, k++));
            temp2 = ht.get(c2);
            //System.out.println(is[i] + " " + it[i]);
            if(temp1 != temp2) return false;
        }
        return true;
    }
}