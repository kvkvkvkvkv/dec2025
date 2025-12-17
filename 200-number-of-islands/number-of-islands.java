class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    numIslands(grid, i,j);
                }
            }
        }
        return count;
    }

    public void numIslands(char[][] grid, int r, int c) {
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]=='0') {
            return;
        }
        grid[r][c] = '0';
        for(int[] d:dir) {
            int row = d[0]+r;
            int col = d[1]+c;
            numIslands(grid, row, col);
        }
    }
}