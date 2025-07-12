class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice, cellPrice;
        int profit = 0;
        buyPrice = prices[0];
        for(int i=0; i<prices.length; i++) {
            if(i+1 < prices.length && prices[i] <= prices[i+1]) continue;
            cellPrice = prices[i];
            profit += cellPrice - buyPrice;
            if(i+1 <prices.length) {
                buyPrice = prices[i+1];
            }
        }
        return profit;
    }
}