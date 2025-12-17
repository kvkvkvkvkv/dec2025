class Solution {
    List<List<String>> ans = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] val = new char[n][n];

        for(int i=0;i<n;i++) {
            Arrays.fill(val[i],'.');
        }
        solve(n,0,-7,new HashSet(),new HashSet(), new HashSet(),val);
        return ans;
    }

    public void solve(int n, int r, int prev, Set<Integer> set, Set<Integer> d1, Set<Integer> d2, char[][] val) {
        if(r==n) {
            if(set.size()==n) {
                List<String> temp = new ArrayList();
                for(char[] t:val){
                    temp.add(String.valueOf(t));
                }
                ans.add(temp);
            }
            return;
        }


        for(int i=0;i<n;i++) {
            if(!set.contains(i) && !d1.contains(r-i) && !d2.contains(r+i)) {
                set.add(i);
                d1.add(r-i);
                d2.add(r+i);
                val[r][i] = 'Q';
                solve(n, r+1, i, set, d1,d2,val);
                val[r][i] = '.';
                set.remove(i);
                d1.remove(r-i);
                d2.remove(r+i);
            }
        }
    }
}