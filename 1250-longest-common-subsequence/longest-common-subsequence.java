class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        return dfs(text1, text2, 0, 0);
    }

    public int dfs(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) return 0;
        if(dp[i][j] != 0) {
            return dp[i][j] == -1? 0: dp[i][j];
        }
        int res = 0;

        if(text1.charAt(i) == text2.charAt(j)) {
            res = dfs(text1, text2, i+1, j+1) + 1;
        }
        else {
            res = Math.max(dfs(text1, text2, i+1, j), dfs(text1, text2, i, j+1));
        }

        dp[i][j] = res == 0?-1:res;


        return res;
    }
}
