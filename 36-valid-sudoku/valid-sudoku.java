class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap();
        Map<Integer, Set<Character>> cols = new HashMap();
        Map<Integer, Set<Character>> cell = new HashMap();

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char cur = board[r][c];
                int val = ((r/3)*3)+(c/3);
                rows.putIfAbsent(r, new HashSet());
                cols.putIfAbsent(c, new HashSet());
                cell.putIfAbsent(val, new HashSet());
                if(cur != '.') {
                    if(rows.get(r).contains(cur) || cols.get(c).contains(cur) || 
                    cell.get(val).contains(cur)) {
                        return false;
                    }
                    rows.get(r).add(cur);
                    cols.get(c).add(cur);
                    cell.get(val).add(cur);
                }
            }
        }
        return true;
    }
}