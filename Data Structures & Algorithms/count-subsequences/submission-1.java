class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcs(0, 0, s, t, memo);
    }

    private int lcs(int i1, int i2, String s, String t, int[][] memo) {
        if (i2 == t.length()) return 1;
        if (i1 == s.length()) return 0;
        if (memo[i1][i2] != -1) return memo[i1][i2];
        memo[i1][i2] = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            memo[i1][i2] += lcs(i1 + 1, i2 + 1, s, t, memo);
        }
        memo[i1][i2] += lcs(i1 + 1, i2, s, t, memo);
        return memo[i1][i2];
    }
}
