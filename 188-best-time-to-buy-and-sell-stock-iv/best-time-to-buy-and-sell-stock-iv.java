class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k+1][prices.length];
        int min;
        for(int t=1; t<=k; t++) {
            min = prices[0];
            for(int i=1; i<prices.length; i++){
                min = Math.min(min, prices[i]-dp[t-1][i-1]);
                dp[t][i] = Math.max(dp[t][i-1], prices[i]-min);
            }
        }
        // for(int i=0; i<dp.length; i++) {
        //     for(int j=0; j<prices.length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[k][prices.length-1];
    }
}