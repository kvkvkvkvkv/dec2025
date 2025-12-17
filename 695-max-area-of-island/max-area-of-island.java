class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    max = Math.max(max,max(grid,i,j));
                }
            }
        }
        return max;
    }

    public int max(int[][] grid, int r, int c) {
        if(r==grid.length || c==grid[0].length || r<0 || c<0 || grid[r][c]== 0) {
            return 0;
        }
        grid[r][c]=0;
        return 1+max(grid,r+1,c)+max(grid,r-1,c)+max(grid,r,c+1)+max(grid,r,c-1);
    }
}