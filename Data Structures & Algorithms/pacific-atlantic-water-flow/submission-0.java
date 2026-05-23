class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int M = heights.length, N = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] atlantic = new boolean[M][N];
        boolean[][] pacific = new boolean[M][N];
        for (int c = 0; c < N; c++) {
            canFlow(heights, 0, c, pacific, heights[0][c]);
            canFlow(heights, M - 1, c, atlantic, heights[M - 1][c]);
        }

        for (int r = 0; r < M; r++) {
            canFlow(heights, r, 0, pacific, heights[r][0]);
            canFlow(heights, r, N - 1, atlantic, heights[r][N - 1]);
        }

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void canFlow(int[][] heights, int r, int c, boolean[][] visit, int prevH) {
        int M = heights.length, N = heights[0].length;
        if ((r < 0 || r == M || c < 0 || c == N || visit[r][c] || heights[r][c] < prevH)) {
            return;
        }
        visit[r][c] = true;
        canFlow(heights, r - 1, c, visit, heights[r][c]);
        canFlow(heights, r + 1, c, visit, heights[r][c]);
        canFlow(heights, r, c - 1, visit, heights[r][c]);
        canFlow(heights, r, c + 1, visit, heights[r][c]);
    }


}
