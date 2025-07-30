class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        long dp[][] = new long[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                long curCost = waitCost[i][j] + (long)(i + 1) * (j + 1);
                long min = Long.MAX_VALUE;
                if(i > 0) {
                    min = Math.min(min, dp[i-1][j]);
                }
                if(j > 0) {
                    min = Math.min(min, dp[i][j-1]);
                }
                if(min != Long.MAX_VALUE) {
                    dp[i][j] = curCost + min;
                }
                else {
                    dp[i][j] = curCost;
                }
            }
        }
        return dp[m-1][n-1] - waitCost[0][0] - waitCost[m-1][n-1];
    }
}