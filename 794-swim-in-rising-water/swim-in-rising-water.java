class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        q.add(new int[]{0,0,grid[0][0]});
        boolean[][] seen = new boolean[grid.length][grid[0].length];


        while(!q.isEmpty()) {
            int[] top = q.poll();
            if(seen[top[0]][top[1]]) {
                continue;
            }
            if(top[0]==grid.length-1 && top[1]==grid.length-1) {
                return top[2];
            }
            seen[top[0]][top[1]] = true;

            for(int[] d:dir) {
                int r = d[0]+top[0];
                int c = d[1]+top[1];

                if(r<0 || c<0 || r==grid.length || c==grid.length || seen[r][c]) {
                    continue;
                }
                q.add(new int[]{r,c,Math.max(grid[r][c], top[2])});
            }
        }
        return 0;
    }
}