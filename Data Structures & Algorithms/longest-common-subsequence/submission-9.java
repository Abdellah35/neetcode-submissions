class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length(), M = text2.length();
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int[] curRow = new int[M + 1];
            for (int j = 0; j < M; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curRow[j + 1] = 1 + dp[j];
                } else {
                    curRow[j + 1] = Math.max(dp[j + 1], curRow[j]);
                }
            }
            dp = curRow;
        }

        return dp[M];
    }

}
