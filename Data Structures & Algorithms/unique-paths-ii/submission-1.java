class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] prevRow = new int[n];
        prevRow[n - 1] = 1;

        for (int r = m - 1; r > -1; r--) {
            int[] curRow = new int[n];
            curRow[n - 1] = (obstacleGrid[r][n - 1] == 1 || prevRow[n - 1] == 0) ? 0 : 1;
            for (int c = n - 2; c > -1; c--) {
                curRow[c] = obstacleGrid[r][c] == 1 ? 0 : curRow[c + 1] + prevRow[c];
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}