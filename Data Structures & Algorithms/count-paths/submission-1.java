class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        for (int r = 0; r < m; r++) {
            int[] curRow = new int[n];
            curRow[n - 1] = 1;
            for (int c = n - 2; c > -1; c--) {
                curRow[c] = curRow[c + 1] + prevRow[c];
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}
