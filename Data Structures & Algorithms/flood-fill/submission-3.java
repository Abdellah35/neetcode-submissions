class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(sr, sc, image[sr][sc], color, image, new boolean[image.length][image[0].length]);
        return image;
    }

    private void dfs(int r, int c, int originalColor, int newColor, int[][] image, boolean[][] visit) {
        int R = image.length, C = image[0].length;
        if (r < 0 || c < 0 || R == r || C == c || visit[r][c] || image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        visit[r][c] = true;
        dfs(r + 1, c, originalColor, newColor, image, visit);
        dfs(r - 1, c, originalColor, newColor, image, visit);
        dfs(r, c + 1, originalColor, newColor, image, visit);
        dfs(r, c - 1, originalColor, newColor, image, visit);
        visit[r][c] = false;
    }
}