/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return built(grid, 0, 0, grid.length-1, grid.length-1);
    }

    // public Tree construct(int[][] grid, int s1,int e1, int s2, int e2) {
        
    //     if(s1==s2 && e1==e2) {
    //         return new Node(grid[s1][e1],true);
    //     }

    //     int mid = (s2-s1)/2;
    //     Tree q1 = construct(grid, s1, e1, mid, mid);
    //     Tree q2 = construct(grid, s1, mid+1, mid, e2);
    //     Tree q3 = construct(grid, mid+1, e1, s2, mid);
    //     Tree q4 = construct(grid, mid+1, mid+1, s2, e2);

    //     int sum = q1+q2+q3+q4;
    //     int tot = (s2-s1+1)*(e2-e1+1);
    //     if(sum == tot) {
    //         return tot;
    //     }
    // }

    public Node built(int[][] grid, int s1,int e1, int s2, int e2) {
        
        if(s1==s2 && e1==e2) {
            boolean val = grid[s1][e1] == 1;
            return new Node(val,true);
        }

        Node root = new Node();

        int rMid = s1 + (s2 - s1) / 2;
        int cMid = e1 + (e2 - e1) / 2;

        Node q1 = built(grid, s1, e1, rMid, cMid);
        Node q2 = built(grid, s1, cMid+1, rMid, e2);
        Node q3 = built(grid, rMid+1, e1, s2, cMid);
        Node q4 = built(grid, rMid+1, cMid+1, s2, e2);

        boolean isSame = isSame(q1,q2,q3,q4);

        if(isSame) {
            root.val = q1.val;
            root.isLeaf = true;
        } else {
            root.isLeaf = false;
            root.topLeft = q1;
            root.topRight = q2;
            root.bottomLeft = q3;
            root.bottomRight = q4;
        }

        return root;
    }

    boolean isSame(Node q1, Node q2, Node q3, Node q4) {
        return q1.val == q2.val && q2.val == q3.val && q3.val == q4.val 
        && q1.isLeaf && q2.isLeaf && q3.isLeaf && q4.isLeaf;
    }
}

class Tree {
    Node node;
    int count;

    Tree(Node node, int count) {
        this.node = node;
        this.count = count;
    }
}