class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int max = 5000;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int minH;
                if(i == n-1 && j == m-1) {
                    minH = dungeon[i][j]>=0?1:-dungeon[i][j]+1;
                    dp[i][j] = minH;
                    continue;
                }
                int rightMin = (j==m-1)? max: dp[i][j+1];
                int downMin = (i==n-1)?max: dp[i+1][j];
                minH = Math.min(rightMin, downMin) - dungeon[i][j];
                dp[i][j] = minH <= 0? 1: minH;

            }
        }
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         System.out.print(dp[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][0];
    }
}