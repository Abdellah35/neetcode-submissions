class Solution {
    public int numDistinct(String s, String t) {
        int N = s.length(), M = t.length();
        if (N < M) return 0;
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(s, t, 0, 0, cache);
    }

    private int dfs(String s, String t, int i, int j, int[][] cache) {
        if ( i == s.length() || t.length() == j) {
            return t.length() == j ? 1 : 0;
        }
        if (cache[i][j] != -1) return cache[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            cache[i][j] = dfs(s, t, i + 1, j, cache) + dfs(s, t, i + 1, j + 1, cache);
        } else {
            cache[i][j] = dfs(s, t, i + 1, j, cache);
        }

        return cache[i][j];
    }
}

