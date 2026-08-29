class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, R = grid.length, C = grid[0].length;
        boolean[][] visit = new boolean[R][C];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid) {
        int R = grid.length, C = grid[0].length;
        if (r < 0 || c < 0 || r == R || c == C || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        int area = 1;
        area += dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid)+ dfs(r, c - 1, grid);

        return area;
    }
}
