class Solution {
    public int maxProfit(int[] prices) {
        int buy, sell, profit=0, i, temp;
        buy = prices[0];
        for(i=1; i<prices.length; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
            }
            if(prices[i] > buy) {
                temp = prices[i] - buy;
                if(temp > profit) {
                    profit = temp;
                }
            }
        }
        return profit;

    }
}