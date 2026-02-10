class Solution {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O') {
                queue.add(new int[]{i,0});
            }

            if(board[i][n-1] == 'O') {
                queue.add(new int[]{i,n-1});
            }
        }

        for(int i=0;i<n;i++) {
            if(board[0][i] == 'O') {
                queue.add(new int[]{0,i});
            }

            if(board[m-1][i] == 'O') {
                queue.add(new int[]{m-1,i});
            }
        }


        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            board[top[0]][top[1]] = 'Y';

            for(int[] dir:direction) {
                int r = dir[0]+top[0];
                int c = dir[1]+top[1];

                if(r>=0 && c>=0 && r<m && c<n && board[r][c]=='O') {
                    queue.add(new int[]{r,c});
                    board[r][c] = 'Y';
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}