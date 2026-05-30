class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        int length = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] neighbors = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
                for (int[] nei: neighbors) {
                    int nr = r + nei[0], nc = c + nei[1];

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
