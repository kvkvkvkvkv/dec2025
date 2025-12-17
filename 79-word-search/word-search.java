class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(word.charAt(0)==board[i][j]) {
                    if(exist(board, word, i, j, 0, new HashSet())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int i, int j, int index, Set<Pair<Integer,Integer>> seen) {
        
        if(index == word.length()) {
            return true;
        }
        Pair<Integer, Integer> pair = new Pair(i,j);
        char cur = word.charAt(index);
        if(i<0 || j<0 || i==board.length || j==board[0].length || seen.contains(pair) || board[i][j]!=cur) {
            return false;
        }

        seen.add(pair);
        if(exist(board, word, i+1, j, index+1, seen) ||
        exist(board, word, i-1, j, index+1, seen) || 
        exist(board, word, i, j+1, index+1, seen) ||
        exist(board, word, i, j-1, index+1, seen)) {
            return true;
        }
        seen.remove(pair);
        return false;
    }
}