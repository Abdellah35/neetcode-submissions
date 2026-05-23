class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int yesterday = prices[i - 1];
            int today = prices[i];
            maxProfit += today > yesterday ? today - yesterday : 0; 
        }

        return maxProfit;
    }
}