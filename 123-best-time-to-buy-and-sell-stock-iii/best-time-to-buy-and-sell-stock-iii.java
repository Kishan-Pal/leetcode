class Solution {
    public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int[][] dp = new int[3][prices.length];
            for (int k = 1; k <= 2; k++) {
                int min = prices[0];
                for (int i = 1; i < prices.length; i++) {
                    
                    min = Math.min(min, prices[i] - dp[k-1][i-1]);
                    dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
                    // System.out.print(min + " " );
                }
                // System.out.println();
            }

            
            // for(int i=0; i<dp.length; i++) {
            //     for(int j=0; j<dp[0].length; j++) {
            //         System.out.print(dp[i][j] + " " );
            //     }
            //     System.out.println();
            // }

            return dp[2][prices.length - 1];
        }
}