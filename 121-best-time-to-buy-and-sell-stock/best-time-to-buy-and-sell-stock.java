class Solution {
    public int maxProfit(int[] prices) {
        int buy, sell, profit=0, i, temp;
        buy = prices[0];
        for(i=1; i<prices.length; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
            }
            else {
                temp = prices[i] - buy;
                profit = (temp>profit)?temp:profit;
            }
        }
        return profit;

    }
}