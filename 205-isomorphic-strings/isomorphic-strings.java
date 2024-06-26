class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] hs = new int[200];
        int[] ht = new int[200];
        int n = s.length();
        int j=1, k=1, temp1, temp2;
        for(int i=0; i<n; i++) {
            char c1 = s.charAt(i);
            temp1 = hs[(int)c1] = (hs[(int)c1] == 0? j++: hs[(int)c1]);
            char c2 = t.charAt(i);
            temp2 = ht[(int)c2] = (ht[(int)c2] == 0? k++: ht[(int)c2]);
            //System.out.println(is[i] + " " + it[i]);
            if(temp1 != temp2) return false;
        }
        return true;
    }
}