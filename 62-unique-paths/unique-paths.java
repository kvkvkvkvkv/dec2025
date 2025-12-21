class Solution {
    Integer[][] memo;
    int[][] dir = {{0,1},{1,0}};
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return uniquePaths(m, n, 0, 0);
    }

    public int uniquePaths(int m, int n, int i, int j) {
        if(i<0 || j<0 || i==m || j==n) {
            return 0;
        }

        if(i==m-1 && j==n-1) {
            return 1;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        int ans = 0;
        for(int[] d:dir) {
            int r=d[0]+i;
            int c=d[1]+j;
            ans += uniquePaths(m, n, r, c);
        }

        return memo[i][j] = ans;
    }
}