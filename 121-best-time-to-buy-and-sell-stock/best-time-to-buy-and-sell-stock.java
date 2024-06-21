class Solution {
    public int maxProfit(int[] prices) {
        int buy, sell, profit=0, i, temp;
        buy = prices[0];
        for(i=1; i<prices.length; i++) {
            
            buy = (buy>prices[i])?prices[i]:buy;
            temp = prices[i] - buy;
            profit = (temp>profit)?temp:profit;

        }
        return profit;

    }
}