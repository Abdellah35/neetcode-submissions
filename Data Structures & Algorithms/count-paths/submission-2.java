class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, m, n, new boolean[m][n], memo);
    }

    private int dfs(int r, int c, int R, int C, boolean[][] visit, int[][] memo) {
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c]) {
            return 0;
        }
        if (memo[r][c] != -1) return memo[r][c];
        if (r == R - 1 && c == C - 1) {
            return 1;
        }

        visit[r][c] = true;
        memo[r][c] = dfs(r + 1, c, R, C, visit, memo) + dfs(r, c + 1, R, C, visit, memo);
        visit[r][c] = false;
        return memo[r][c];
    }
}
