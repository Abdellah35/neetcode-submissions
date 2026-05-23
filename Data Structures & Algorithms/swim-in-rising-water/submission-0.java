class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Queue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new Integer[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[N][N];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!minHeap.isEmpty()) {
            Integer[] q = minHeap.remove();
            int t = q[0], r = q[1], c = q[2];
            if (r == N - 1 && c == N - 1) {
                return t;
            }
            for (int[] dir: directions) {
                int dr = r + dir[0], dc = c + dir[1];
                if (dr < 0 || dc < 0 || dr >= N || dc >= N || visited[dr][dc]) continue;
                visited[dr][dc] = true;
                minHeap.offer(new Integer[]{Math.max(t, grid[dr][dc]), dr, dc});
            }
        }

        return -1;
    }
}
