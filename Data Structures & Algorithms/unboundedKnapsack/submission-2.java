class Solution {
    int[][] cache;
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[][] dp = new int[n][capacity + 1];
        for (int c = 0; c < capacity + 1; c++) {
            if (c >= weight.get(0)) {
                dp[0][c] = profit.get(0) + dp[0][c - weight.get(0)];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c < capacity + 1; c++) {
                int skip = dp[i-1][c];
                int include = 0;
                if (c >= weight.get(i)) {
                    include = profit.get(i) + dp[i][c - weight.get(i)];
                }
                dp[i][c] = Math.max(skip, include);
            }
        }

        return dp[n - 1][capacity];
    }
}
