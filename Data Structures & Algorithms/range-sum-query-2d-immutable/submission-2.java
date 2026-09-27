class NumMatrix {
    int[][] prefixMat;

    public NumMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        prefixMat = new int[R + 1][C + 1];

        for (int r = 0; r < R; r++) {
            int prefix = 0;
            for (int c = 0; c < C; c++) {
                prefix += matrix[r][c];
                prefixMat[r + 1][c + 1] = prefix + prefixMat[r][c + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomRight = prefixMat[row2 + 1][col2 + 1];
        int above = prefixMat[row1][col2 + 1];
        int left = prefixMat[row2 + 1][col1];
        int topLeft = prefixMat[row1][col1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */