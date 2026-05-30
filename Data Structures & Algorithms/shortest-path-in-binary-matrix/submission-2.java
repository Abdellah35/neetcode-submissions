class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[ROWS][COLS];
        if (grid[0][0] == 1 || grid[ROWS - 1][COLS-1] == 1) return -1;
        queue.add(new int[]{0, 0});
        visit[0][0] = true;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
        int length = 1;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                for (int[] dir: directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS || grid[nr][nc] == 1 || visit[nr][nc]) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc});
                    visit[nr][nc] = true;
                }
            }
            length++;
        }

        return -1;
    }
}