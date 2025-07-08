class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }
    public boolean dp(int i, int j, String s, String p) {
        if(j == p.length()) {
            return memo[i][j] = (i == s.length());
        }
        if(i > s.length()) return false;
        if(memo[i][j] != null && memo[i][j] == false) return false;

        if(p.charAt(j) == '*') {
            while(j < p.length() && p.charAt(j) == '*') {
                j++;
            }
            j--;
            boolean ans = dp(i+1, j, s, p) || dp(i, j+1, s, p);
            memo[i][j] = ans;
            return ans;
        }
        if(i < s.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
            boolean ans = dp(i+1, j+1, s, p);
            memo[i][j] = ans;
            return ans;
        }
        memo[i][j] = false;

        return false;
    }
}