class Solution {

    public int dfs(int m, int n, int i, int j, int dist, int[][] dp, int[][] a) {
        if(i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = dfs(m, n, i, j+1, a[i][j], dp, a);
        int down = dfs(m, n, i+1, j, a[i][j], dp, a);
        dp[i][j] = a[i][j] + Math.min(right, down);
        
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[m-1][n-1] = grid[m-1][n-1];
        int result = dfs(m, n, 0, 0, 0, dp, grid);
        return result;
    }
}