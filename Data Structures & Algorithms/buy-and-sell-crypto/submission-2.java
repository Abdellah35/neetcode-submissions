class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, l = 0;
        int minBuy = prices[0];
        for (int r = 1; r < prices.length; r++) {
            if (prices[r] < minBuy) {
                minBuy = prices[r];
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - minBuy);
            }
        }

        return maxProfit;
    }
}
