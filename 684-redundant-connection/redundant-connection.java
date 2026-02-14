class Solution {

    int[] root;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int[] temp = new int[2];
        int n = edges.length;
        root = new int[n+1];
        rank = new int[n+1];
        init();
        for(int[] ele:edges) {
            if(!union(ele[0],ele[1])) {
                temp = ele;
            }
        }
        return temp;
    }

    void init() {
        for(int i=0;i<root.length;i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if(root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) {
            return false;
        }

        if(rank[rootX]>rank[rootY]) {
            root[rootY] = rootX;
        } else if(rank[rootY]>rank[rootX]) {
            root[rootX] = rootY;
        } else {
            rank[rootY]++;
            root[rootX] = rootY;
        }
        return true;
    }
}