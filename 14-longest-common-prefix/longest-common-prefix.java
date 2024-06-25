class Solution {
    public String common(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String res = "";
        for(int i=0; i<n && i<m; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                break;
            }
            res = res + s1.charAt(i);
        }
        return res;

    }

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int n = strs.length;
        for(int i=1; i<n; i++) {
            res = this.common(res, strs[i]);
        }
        return res;
    }
}