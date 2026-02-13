class Solution {
    boolean[] seen;
    public boolean validTree(int n, int[][] edges) {
        seen = new boolean[n];
        Map<Integer,List<Integer>> map = new HashMap<>();

        if(edges.length+1 != n) {
            return false;
        }
        for(int[] ele:edges) {
            map.computeIfAbsent(ele[0], key -> new ArrayList()).add(ele[1]);
            map.computeIfAbsent(ele[1], key -> new ArrayList()).add(ele[0]);
        }
        if(dfs(0, -1, map)) {
            return false;
        }   

        int count = 0;
        for(int i=0;i<n;i++) {
            if(seen[i]) {
                count++;
            }
        }
        return count == edges.length+1;
    }

    boolean dfs(int node, int parent, Map<Integer, List<Integer>> map) {
        if(seen[node]) {
            return true;
        }

        seen[node] = true;
        if(map.get(node) == null) {
            return false;
        }
        
        for(int ele:map.get(node)) {
            if(ele != parent) {
                if(dfs(ele, node, map)) {
                    return true;
                }
            }
        }
        return false;
    }
}