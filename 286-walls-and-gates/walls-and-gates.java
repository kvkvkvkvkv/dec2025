class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public void wallsAndGates(int[][] rooms) {
        
        Queue<Node> q = new LinkedList();

        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
                if(rooms[i][j] == 0) {
                    q.add(new Node(i,j,0));
                }
            }
        }

        while(!q.isEmpty()) {
            Node front = q.remove();

            for(int[] d:dir) {
                int r=d[0]+front.r;
                int c=d[1]+front.c;

                if(r<0 || c<0 || r==rooms.length || c==rooms[0].length || rooms[r][c]==-1) {
                    continue;
                }

                if(1+front.val>=rooms[r][c]) {
                    continue;
                }

                rooms[r][c] = 1+front.val;
                q.add(new Node(r,c,rooms[r][c]));
            }
        }    
    }
}

class Node {
    int r;
    int c;
    int val;

    Node(int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }
}