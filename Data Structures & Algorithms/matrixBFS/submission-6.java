class Solution {
    public int shortestPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int R = grid.length, C = grid[0].length;
        boolean[][] visit = new boolean[R][C];

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;
        int length = 0;

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                if (r == R - 1 && c == C - 1) {
                    return length;
                }
                
                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] nei: dirs) {
                    int dr = r + nei[0], dc = c + nei[1];
                    if (dr < 0 || dc < 0 || dr == R || dc == C || visit[dr][dc] || grid[dr][dc] == 1) {
                        continue;
                    }
                    q.add(new int[]{dr, dc});
                    visit[dr][dc] = true;
                }
            }
            length++;
        }

        return -1;
    }
}
