class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int N = heights.length, M = heights[0].length;

        boolean[][] pacific = new boolean[N][M];
        boolean[][] atlantic = new boolean[N][M];
        for (int c = 0; c < M; c++) {
            backtrack(0, c, heights, heights[0][c], pacific);
            backtrack(N - 1, c, heights, heights[N - 1][c], atlantic);
        }

        for (int r = 0; r < N; r++) {
            backtrack(r, 0, heights, heights[r][0], pacific);
            backtrack(r, M - 1, heights, heights[r][M - 1], atlantic);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void backtrack(int r, int c, int[][] heights, int prevHeight, boolean[][] visit) {
        int R = heights.length, C = heights[0].length;
        if ( r < 0 || c < 0 || r >= R || c >= C || visit[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visit[r][c] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: directions) {
            int dr = r + dir[0], dc = c + dir[1];
            backtrack(dr, dc, heights, heights[r][c], visit);
        }
    }
}
