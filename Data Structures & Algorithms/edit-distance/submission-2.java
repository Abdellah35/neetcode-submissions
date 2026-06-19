class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcs(0, 0, word1, word2, memo);
    }

    private int lcs(int i, int j, String word1, String word2, int[][] memo) {
        if (j == word2.length()) return word1.length() - i;
        if (i == word1.length()) return word2.length() - j;
        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = lcs(i + 1, j + 1, word1, word2, memo);
        } else {
            int insert = 1 + lcs(i, j + 1, word1, word2, memo);
            int delete = 1 + lcs(i + 1, j, word1, word2, memo);
            int replace = 1 + lcs(i + 1, j + 1, word1, word2, memo);
            memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
        return memo[i][j];
    }
}
