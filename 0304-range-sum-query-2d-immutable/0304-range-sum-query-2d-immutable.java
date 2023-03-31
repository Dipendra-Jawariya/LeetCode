class NumMatrix {
    public int mat[][];
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        mat = new int[row+1][col+1];
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                mat[i][j] = mat[i-1][j] + mat[i][j-1] + matrix[i-1][j-1] - mat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return mat[row2][col2] - mat[row1-1][col2] - mat[row2][col1-1] + mat[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */