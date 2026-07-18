class Solution {
    public int swimInWater(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new Integer[]{grid[0][0], 0, 0});
        boolean[][] visit = new boolean[R][C];
        int level = grid[0][0];
        while (!minHeap.isEmpty()) {
            Integer[] cur = minHeap.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            level = Math.max(t, level);
            if (r == R - 1 && c == C - 1) {
                break;
            }
            visit[r][c] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (var dir: directions) {
                int rd = r + dir[0], cd = c + dir[1];
                if (rd < 0 || cd < 0 || rd == R || cd == C || visit[rd][cd]) {
                    continue;
                }
                int newT = Math.max(level, grid[rd][cd]);
                minHeap.offer(new Integer[]{newT, rd, cd});
            }
        }

        return level;
    }
}
