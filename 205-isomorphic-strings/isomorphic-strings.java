class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] hs = new int[200];
        int[] ht = new int[200];
        int j=1, k=1, temp1, temp2;
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            if(hs[(int)c1] == 0) {
                hs[(int)c1] = j++;
            }
            temp1 = hs[(int)c1];
            char c2 = t.charAt(i);
            if(ht[(int)c2] == 0) {
                ht[(int)c2] = k++;
            }
            temp2 = ht[(int)c2];
            //System.out.println(is[i] + " " + it[i]);
            if(temp1 != temp2) return false;
        }
        return true;
    }
}