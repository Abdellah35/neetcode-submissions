class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int N = s1.length(), M = s2.length();
        if (N + M != s3.length()) return false;
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[N][M] = true;
        for (int i = N; i > -1; i--) {
            for (int j = M; j > -1; j--) {
                if (i < N && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < M && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}
