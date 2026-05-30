class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];

        int maxArea = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !visit[r][c]) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c, visit));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || visit[r][c]) {
            return 0;
        }
        int count = 1;
        visit[r][c] = true;
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r, c - 1, visit);
        count += dfs(grid, r, c + 1, visit);

        return count;
    }
}
