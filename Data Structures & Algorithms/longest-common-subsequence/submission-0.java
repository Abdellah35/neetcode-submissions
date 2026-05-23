class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(), N = text2.length();
        int[][] dp = new int[M + 1][N + 1];

        for (int r = M - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = dp[r + 1][c + 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
