class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];
        int islands = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!visit[r][c] && grid[r][c] == '1') {
                    dfs(grid, r, c, visit);
                    islands++;
                }
            }
        }
    
        return islands;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0' || visit[r][c]) {
            return;
        }

        visit[r][c] = true;
        dfs(grid, r - 1, c, visit);
        dfs(grid, r + 1, c, visit);
        dfs(grid, r, c - 1, visit);
        dfs(grid, r, c + 1, visit);
    }
}
