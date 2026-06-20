class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s, new StringBuilder(s).reverse().toString());
    }

    private int lcs(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[N][M];
    }
}