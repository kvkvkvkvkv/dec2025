class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    Integer[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        memo = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                max = Math.max(max,path(matrix, i,j));
            }
        }
        return max;
    }

    public int path(int[][] matrix, int i, int j) {
        if(memo[i][j] != null) {
            return memo[i][j];
        }

        int max = 1;
        for(int[] d:dir) {
            int r = i+d[0];
            int c = j+d[1];
            if(r<0 || c<0 || r==matrix.length || c==matrix[0].length || matrix[i][j]>=matrix[r][c]) {
                continue;
            }
            max = Math.max(max, 1+ path(matrix,r,c));
        }

        return memo[i][j] = max;
    }
}