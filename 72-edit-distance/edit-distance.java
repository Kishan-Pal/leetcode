class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        return dfs(word1, word2, 0, 0);
    }

    public int dfs(String word1, String word2, int i, int j) {
        if(i == word1.length() || j == word2.length()) {
            return word1.length() - i + word2.length() - j;
        }

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;

        if(word1.charAt(i) == word2.charAt(j)) {
            res = dfs(word1, word2, i+1, j+1);
        }
        int del = dfs(word1, word2, i+1, j) + 1;
        int ins = dfs(word1, word2, i, j+1) + 1;
        int rep = dfs(word1, word2, i+1, j+1) + 1;
        res = Math.min(res, Math.min(Math.min(del, ins), rep));
        dp[i][j] = res;
        return res;
        
    }
}
