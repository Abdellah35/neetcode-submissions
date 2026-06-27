class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i < n + 1; i++) {
            int tmp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = tmp;
        }

        return dp[1];
    }
}
