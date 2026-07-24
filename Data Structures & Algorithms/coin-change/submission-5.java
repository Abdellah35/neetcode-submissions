class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length, M = amount + 1;
        int[] dp = new int[M];
        Arrays.fill(dp, M);
        dp[0] = 0;

        for (int a = 1; a < M; a++) {
            for (int c: coins) {
                if (a - c >= 0)
                dp[a] = Math.min(dp[a], 1 + dp[a - c]);
            }
        }

        return dp[M - 1] != M ? dp[M - 1] : -1;
    }
}
