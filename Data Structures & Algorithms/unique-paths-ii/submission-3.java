class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] prevRow = new int[m];
        for (int r = n - 1; r > -1; r--) {
            int[] curRow = new int[m];
            if (obstacleGrid[r][m-1] == 0) {
                if (r == n - 1 || (obstacleGrid[r+1][m-1] == 0 && prevRow[m-1] == 1)) {
                    curRow[m - 1] = 1;
                }
            }
            for (int c = m - 2; c > -1; c--) {
                if (obstacleGrid[r][c] == 0) {
                    curRow[c] = curRow[c + 1] + prevRow[c];
                }
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}