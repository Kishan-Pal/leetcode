class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        int buyPrice = prices[0];
        int totalProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            else if (prices[i] > buyPrice + fee) {
                totalProfit += prices[i] - buyPrice - fee;
                buyPrice = prices[i] - fee;
            }
        }

        return totalProfit;
    }
}
