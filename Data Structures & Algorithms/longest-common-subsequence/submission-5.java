class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcs(0, 0, text1, text2, memo);
    }

    private int lcs(int i1, int i2, String s1, String s2, int[][] memo) {
        if (i1 >= s1.length() || i2 >= s2.length()) {
            return 0;
        }
        if (memo[i1][i2] != -1) return memo[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2)) {
            memo[i1][i2] = 1 + lcs(i1 + 1, i2 + 1, s1, s2, memo);
        } else {
            memo[i1][i2] = Math.max(lcs(i1 + 1, i2, s1, s2, memo), lcs(i1, i2 + 1, s1, s2, memo));
        }
        return memo[i1][i2];
    }
}
