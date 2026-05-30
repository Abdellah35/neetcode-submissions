class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int minute = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(fresh > 0 && !queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
                for (int[] dir: directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    queue.add(new int[]{nr, nc});
                    fresh--;
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
