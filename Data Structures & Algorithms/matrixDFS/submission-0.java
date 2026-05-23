class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][] grid, int r, int c, HashSet<String> visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        String pos = r + "," + c;
        if (Math.min(r, c) < 0 || r == ROWS || c == COLS || visited.contains(pos) || grid[r][c] == 1) {
            return 0;
        }
        if ( r == ROWS - 1 && c == COLS - 1) return 1;

        visited.add(pos);
        int count = 0;
        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r, c - 1, visited);

        visited.remove(pos);
        return count;
    }
}
