class Solution {
    public int dfs(int m, int n, int i, int j, int[][] dp, int[][] a) {
        if(i >= m || j >= n || a[i][j] == 1 || a[m-1][n-1] == 1) return 0;
        if(i == m-1 && j == n-1 && a[m-1][n-1] == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int right = dfs(m, n, i, j+1, dp, a);
        int left = dfs(m, n, i+1, j, dp, a);
        dp[i][j] = right + left;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        int result = dfs(m, n, 0, 0, dp, obstacleGrid);
        return result;
    }
}