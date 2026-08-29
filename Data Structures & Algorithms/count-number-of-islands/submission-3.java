class Solution {
    public int numIslands(char[][] grid) {
        int R = grid.length, C = grid[0].length;

        int islands = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int r, int c, char[][] grid) {
        int R = grid.length, C = grid[0].length;
        if (r < 0 || c < 0 || r == R || c == C || grid[r][c] == '0' || grid[r][c] == '2') {
            return;
        }

        grid[r][c] = '2';
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
