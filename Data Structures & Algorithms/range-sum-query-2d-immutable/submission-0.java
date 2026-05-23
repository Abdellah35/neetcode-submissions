class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int prefix = 0;
            for (int j = 0; j < n; j++) {
                prefix += matrix[i][j];
                int above = preSum[i][j + 1];

                preSum[i + 1][j + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = preSum[row2][col2];
        int above = preSum[row1 - 1][col2];
        int left = preSum[row2][col1 - 1];
        int topLeft = preSum[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */