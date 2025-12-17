class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer,Integer>> p = new HashSet();
        Set<Pair<Integer,Integer>> a = new HashSet();
        List<List<Integer>> ans = new ArrayList();
        
        for(int i=0;i<heights.length;i++) {
            dfs(heights,i,0,p);
        }

        for(int i=0;i<heights[0].length;i++) {
            dfs(heights,0,i,p);
        }

        for(int i=0;i<heights.length;i++) {
            dfs(heights,i,heights[0].length-1,a);
        }

        for(int i=0;i<heights[0].length;i++) {
            dfs(heights,heights.length-1,i,a);
        }

        for(Pair<Integer,Integer> ele:p) {
            if(a.contains(ele)) {
                ans.add(Arrays.asList(ele.getKey(),ele.getValue()));
            }
        }
        return ans;
    }


    void dfs(int[][] heights, int r, int c, Set<Pair<Integer,Integer>> seen) {
        Pair<Integer,Integer> pair = new Pair(r,c);
        if(seen.contains(pair)) {
            return;
        }
        seen.add(pair);
        for(int[] d:dir) {
            int i = r+d[0];
            int j = c+d[1];
            if(i<0 || j<0 || i==heights.length || j==heights[0].length || heights[r][c]>heights[i][j]) {
                continue;
            }
            dfs(heights,i,j,seen);
        }
    }
}