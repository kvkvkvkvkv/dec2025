class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int good = 0;
        Queue<Orange> q = new LinkedList();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) {
                    q.add(new Orange(i,j));
                }
                if(grid[i][j]==1) {
                    good++;
                }
            }
        }

        if(good==0) {
            return 0;
        }



        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size>0) {
                Orange top = q.poll();
                for(int[] d:dir) {
                    int r = d[0]+top.x;
                    int c = d[1]+top.y;

                    if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0 || grid[r][c]==2) {
                        continue;
                    }

                    grid[r][c] = 2;
                    q.add(new Orange(r,c));
                }
                size--;
            }
            count++;
        }

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        
        return count-1;
    }
}

class Orange {
    int x;
    int y;

    Orange(int x, int y) {
        this.x = x;
        this.y = y;
    }
}