class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        Queue<Pair<Integer,Integer>> o = new LinkedList();
        
        for(int i=0;i<board.length;i++) {
            if(board[i][0] == 'O') {
                o.add(new Pair(i,0));
            }

            if(board[i][board[0].length-1] == 'O') {
                o.add(new Pair(i,board[0].length-1));
            }
        }

        for(int i=0;i<board[0].length;i++) {
            if(board[0][i] == 'O') {
                o.add(new Pair(0,i));
            }

            if(board[board.length-1][i] == 'O') {
                o.add(new Pair(board.length-1,i));
            }
        }

        while(!o.isEmpty()) {
            Pair<Integer,Integer> top = o.poll();
            board[top.getKey()][top.getValue()] = 'Y';

            for(int[] d:dir) {
                int r = d[0]+top.getKey();
                int c = d[1]+top.getValue();

                if(r<0 || c<0 || r==board.length || c==board[0].length || board[r][c]=='X' || board[r][c]=='Y') {
                    continue;
                } 
                o.add(new Pair(r,c));
            }
        }


        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}