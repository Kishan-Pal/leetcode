class Solution {
    enum Right {
        TRUE, FALSE
    }
    public static Right[][] mapping;
    public boolean isMatch(String s, String p) {
        mapping = new Right[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String s, String p) {
        if(j == p.length()) {
            return i == s.length();
        }
        if(mapping[i][j] != null) {
            return mapping[i][j] == Right.TRUE;
        }
        boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans;
        if(j < p.length() - 1) {
            if(p.charAt(j+1) == '*') {
                ans = dp(i, j+2, s, p) || firstMatch && dp(i+1, j, s, p);
                mapping[i][j] = (ans? Right.TRUE: Right.FALSE);
                return ans;
            }
        }
        if(j < p.length()) {
            ans = firstMatch && dp(i+1, j+1, s, p);
            mapping[i][j] = (ans? Right.TRUE: Right.FALSE);
            return ans;
        }
        return false;
    }
}