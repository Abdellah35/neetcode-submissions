class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        int[] dp = new int[N];
        dp[N - 1] = 1;

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >=0 ; j--) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j + 1 < N) {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }

    private int memoization(int r, int c, int[][] grid, int[][] cache) {
        if (r == grid.length ||  c == grid[0].length || grid[r][c] == 1) {
            return 0;
        }
        if (cache[r][c] != 0) return cache[r][c];

        if (r == grid.length - 1 ||  c == grid[0].length - 1) return 1;

        cache[r][c] = memoization(r + 1, c, grid, cache) + memoization(r, c + 1, grid, cache);

        return cache[r][c];
    }
}