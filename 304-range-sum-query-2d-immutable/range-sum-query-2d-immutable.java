class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(j==0) {
                    sum[i][j] = matrix[i][j];
                } else {
                    sum[i][j] = sum[i][j-1]+matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int tot = 0;
        for(int i=row1;i<=row2;i++) {
            tot+=sum[i][col2];
            if(col1>0) {
                tot-=sum[i][col1-1];
            }
        }
        return tot;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */