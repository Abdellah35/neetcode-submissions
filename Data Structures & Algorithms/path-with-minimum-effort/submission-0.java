class Solution {
    public int minimumEffortPath(int[][] heights) {
        int M = heights.length, N = heights[0].length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[M][N];
        minHeap.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        int minEffort = Integer.MAX_VALUE;

        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            
            for (int i = 0; i < size; i++) {
                int[] cell = minHeap.poll();
                int r = cell[0], c = cell[1], mx = cell[2];
                if (r == M - 1 && c == N - 1) {
                    minEffort = Math.min(minEffort, mx);
                }
                visited[r][c] = true;
                int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                for (int[] d: dirs) {
                    int dr = r + d[0], dc = c + d[1];
                    if (dr >= 0 && dr < M && dc >= 0 && dc < N && !visited[dr][dc]) {
                        int max = Math.max(Math.abs(heights[dr][dc] - heights[r][c]), mx);
                        minHeap.offer(new int[]{dr, dc, max});
                    }
                }
            }
        }

        return minEffort;
    }
}