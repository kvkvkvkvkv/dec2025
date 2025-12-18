class Solution {
    int[] rank;
    int[] root;


    void init() {
        for(int i=0;i<rank.length;i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        rank = new int[points.length];
        root = new int[points.length];

        init();

        PriorityQueue<Node> q = new PriorityQueue<>((a,b) ->
            Integer.compare(a.dis,b.dis));

        for(int i=0;i<points.length;i++) {
            for(int j=i+1;j<points.length;j++) {
                int dis = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                Node cur = new Node(i,j,dis);
                q.add(cur);
            }
        }

        int edge=0;
        int ans = 0;
        while(edge<points.length-1) {
            Node cur = q.poll();
            int val = union(cur);
            if(val>0) {
                edge++;
                ans+=val;
            }
        }
        return ans;
    }

    int union(Node cur) {
        int rX = find(cur.x);
        int rY = find(cur.y);

        if(rX == rY) {
            return 0;
        }

        if(rank[rX]>rank[rY]) {
            root[rY] = rX;
        } else if(rank[rY]>rank[rX]) {
            root[rX] = rY;
        } else {
            rank[rX]++;
            root[rY] = rX;
        }
        return cur.dis;
    }

    int find(int n) {
        if(root[n]==n) {
            return n;
        }
        return root[n] = find(root[n]);
    }
}

class Node {
    int x;
    int y;
    int dis;

    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}