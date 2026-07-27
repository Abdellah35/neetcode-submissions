class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length(), M = word2.length();
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(word1, word2, 0, 0, cache);
    }

    private int dfs(String s1, String s2, int i, int j, int[][] cache) {
        if (s1.length() == i || s2.length() == j) {
            return Math.max(s1.length() - i, s2.length() - j);
        }
        if (cache[i][j] != - 1) return cache[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = dfs(s1, s2, i + 1, j + 1, cache);
        } else {
            cache[i][j] = 1 + Math.min(
                Math.min(dfs(s1, s2, i + 1, j, cache), dfs(s1, s2, i, j + 1, cache)), 
                dfs(s1, s2, i + 1, j + 1, cache));
        }
        return cache[i][j];
    }
}
