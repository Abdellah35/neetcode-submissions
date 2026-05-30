class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new boolean[grid.length][grid[0].length]);
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 1 || visit[r][c]) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visit[r][c] = true;
        int count = 0;
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r, c - 1, visit);
        count += dfs(grid, r, c + 1, visit);

        visit[r][c] = false;
        return count;
    }
}
