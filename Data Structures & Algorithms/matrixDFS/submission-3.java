class Solution {
    public int countPaths(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        return dfs(0, 0, grid, visit);
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visit) {
        int R = grid.length, C = grid[0].length;
        if (r < 0 || c < 0 || R == r || C == c || grid[r][c] == 1 || visit[r][c]) {
            return 0;
        }
        if (r == R - 1 && c == C - 1) {
            return 1;
        }
        visit[r][c] = true;
        int count = dfs(r + 1, c, grid, visit) + dfs(r - 1, c, grid, visit) + dfs(r, c + 1, grid, visit) + dfs(r, c - 1, grid, visit);
        visit[r][c] = false;
        return count;
    }
}
