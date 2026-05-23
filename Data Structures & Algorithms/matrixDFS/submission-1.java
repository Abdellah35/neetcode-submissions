class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][] grid, int r, int c, Set<String> visited) {
        int R = grid.length, C = grid[0].length;
        String pos = r + "," + c;
        if (r < 0 || c < 0 || C == c || R == r || visited.contains(pos) || grid[r][c] == 1) {
            return 0;
        }
        if (r == R - 1 && c == C - 1) {
            return 1;
        }

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
