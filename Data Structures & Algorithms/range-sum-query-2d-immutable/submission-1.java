class NumMatrix {
    int[][] sumMat;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        sumMat = new int[r + 1][c + 1];
        
        for (int i = 0; i < r; i++) {
            int prefix = 0;
            for (int j = 0; j < c; j++) {
                prefix += matrix[i][j];
                sumMat[i + 1][j + 1] = prefix + sumMat[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomRight = sumMat[row2 + 1][col2 + 1];
        int above = sumMat[row1][col2 + 1];
        int left = sumMat[row2 + 1][col1];
        int topLeft = sumMat[row1][col1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
