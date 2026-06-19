class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length(), M = text2.length();
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int[] newR = new int[M + 1];
            for (int j = 0; j < M; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    newR[j+1] = 1 + dp[j];
                } else {
                    newR[j+1] = Math.max(newR[j], dp[j + 1]);
                }
            }
            dp = newR;
        }

        return dp[M];
    }
}
