class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size(), M = capacity + 1;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        for (int c = 0; c < M; c++) {
            if (c >= weight.get(0)) {
                dp[0][c] = profit.get(0) + dp[0][c - weight.get(0)];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int c = 0; c < M; c++) {
                int skip = dp[i - 1][c];
                int include = 0;
                if (c >= weight.get(i)) {
                    include = profit.get(i) + dp[i][c - weight.get(i)];
                }
                dp[i][c] = Math.max(skip, include);
            }
        }

        return dp[N - 1][M - 1];
    }
}
