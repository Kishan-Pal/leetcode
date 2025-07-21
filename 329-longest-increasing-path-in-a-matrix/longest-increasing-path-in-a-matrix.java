class Solution {
    private int[][] dp;
    private int res;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        res = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, -1, matrix));
            }
        }
        return res;
    }

    public int dfs(int i, int j, int prev, int[][] matrix) {
        if(i == matrix.length || j == matrix[0].length || i < 0 || j < 0) return 0;
        if(matrix[i][j] <= prev) return 0;
        // if(dp[i][j] == -1) return 1;
        if(dp[i][j] > 0) return dp[i][j];

        int len1 = dfs(i-1, j, matrix[i][j], matrix);
        int len2 = Math.max(len1, dfs(i, j-1, matrix[i][j], matrix));
        int len3 = Math.max(len2, dfs(i+1, j, matrix[i][j], matrix));
        int len4 = Math.max(len3, dfs(i, j+1, matrix[i][j], matrix));

        dp[i][j] = len4 + 1;

        return len4 + 1;


        
    }
}