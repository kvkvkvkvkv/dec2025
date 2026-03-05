class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cell = new HashMap<>();
        Map<Integer, Set<Character>> r = new HashMap<>();
        Map<Integer, Set<Character>> c = new HashMap<>();

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {

                if(board[i][j] == '.') {
                    continue;
                }

                int idx = (i/3)*3 + (j/3); 
                
                cell.computeIfAbsent(idx, k -> new HashSet<>());
                r.computeIfAbsent(i, k -> new HashSet<>());
                c.computeIfAbsent(j, k -> new HashSet<>());

                if (cell.get(idx).contains(board[i][j])
                || r.get(i).contains(board[i][j]) || c.get(j).contains(board[i][j])) {
                    return false;
                }

                cell.get(idx).add(board[i][j]);
                r.get(i).add(board[i][j]);
                c.get(j).add(board[i][j]);
            }
        }
        return true;
    }
}