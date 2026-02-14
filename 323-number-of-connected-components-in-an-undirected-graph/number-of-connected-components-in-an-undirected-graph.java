class Solution {
    int[] root;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        int count = n;
        root= new int[n];
        rank= new int[n];
        init();
        for(int[] ele:edges) {
            if(union(ele[0],ele[1])) {
                count--;
            }
        }

        return count;
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