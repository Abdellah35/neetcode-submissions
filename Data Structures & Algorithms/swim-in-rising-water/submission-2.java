class Solution {
    public int swimInWater(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        boolean[][] visit = new boolean[M][N];
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int t1 = cur[0], r = cur[1], c = cur[2];
            if (r == M - 1 && c == N - 1) {
                return t1;
            }

            for (int[] dir: directions) {
                int r2 = dir[0] + r, c2 = dir[1] + c;
                if (r2 < 0 || c2 < 0 || r2 >= M || c2 >= N || visit[r2][c2]) continue;
                int t2 = Math.max(t1, grid[r2][c2]);
                minHeap.offer(new int[]{t2, r2, c2});
                visit[r][c] = true;
            }
        }

        return -1;
    }
}
