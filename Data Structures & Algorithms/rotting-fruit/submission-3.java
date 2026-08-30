class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] dir: dirs) {
                    int dr = r + dir[0], dc = c + dir[1];
                    if (dr < 0 || dc < 0 || dr == R || dc == C || grid[dr][dc] != 1) {
                        continue;
                    }
                    q.add(new int[]{dr, dc});
                    grid[dr][dc] = 2;
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
