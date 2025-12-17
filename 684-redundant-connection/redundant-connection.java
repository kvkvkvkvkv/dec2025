class Solution {
    int[] rank;
    int[] root;
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1];
        root = new int[edges.length+1];
        init();

        for(int[] e:edges) {
            if(union(e[0],e[1])) {
                return e;
            }
        }
        return new int[]{};
    }

    int find(int x) {
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }

    boolean union(int x, int y) {
        int rX = find(x);
        int rY = find(y);

        if(rX == rY) {
            return true;
        }

        if(rank[rX]>rank[rY]) {
            root[rY] = rX;
        } else if(rank[rX]< rank[rY]) {
            root[rY] = rX;
        } else {
            rank[rX]++;
            root[rY] = rX;
        }
        return false;
    }

    void init() {
        for(int i=0;i<rank.length;i++) {
            rank[i] = 2;
            root[i] = i;
        }
    }
}