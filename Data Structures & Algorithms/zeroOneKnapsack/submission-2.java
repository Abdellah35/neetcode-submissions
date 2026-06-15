class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size(), M = capacity;
        int[] dp = new int[M + 1];
        for (int c = 1; c < M + 1; c++) {
            if (c >= weight.get(0)) {
                dp[c] = profit.get(0);
            }
        }

        for (int i = 1; i < N; i++) {
            int itemW = weight.get(i);
            for (int c = capacity; c >= itemW; c--) {
                dp[c] = Math.max(dp[c], profit.get(i) + dp[c - itemW]);
            }
        }


        return dp[M]; 
    }
}
