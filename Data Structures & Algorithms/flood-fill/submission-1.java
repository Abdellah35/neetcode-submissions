class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int same = image[sr][sc];
        dfs(image, sr, sc, color, same, new boolean[image.length][image[0].length]);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int same, boolean[][] visit) {
        int ROWS = image.length, COLS = image[0].length;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || image[r][c] != same || visit[r][c]) {
            return;
        }
        image[r][c] = color;
        visit[r][c] = true;
        dfs(image, r - 1, c, color, same, visit);
        dfs(image, r + 1, c, color, same, visit);
        dfs(image, r, c - 1, color, same, visit);
        dfs(image, r, c + 1, color, same, visit);
        visit[r][c] = false;
    }
}