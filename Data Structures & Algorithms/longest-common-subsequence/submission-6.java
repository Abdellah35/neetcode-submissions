class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(text1, text2, 0, 0, cache);
    }

    private int dfs(String s1, String s2, int i, int j, int[][] cache) {
        if (s1.length() == i || s2.length() == j) return 0;
        if (cache[i][j] != -1) return cache[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = 1 + dfs(s1, s2, i + 1, j + 1, cache);
        } else {
            cache[i][j] = Math.max(dfs(s1, s2, i, j + 1, cache), dfs(s1, s2, i + 1, j, cache));
        }

        return cache[i][j];
    }

}
