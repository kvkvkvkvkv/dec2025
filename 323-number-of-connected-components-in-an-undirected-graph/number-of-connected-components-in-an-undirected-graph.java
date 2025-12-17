class Solution {
    boolean[] seen;
    public int countComponents(int n, int[][] edges) {
        seen = new boolean[n];
        int c = 0;
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int[] ele:edges) {
            map.computeIfAbsent(ele[1], i-> new HashSet<>()).add(ele[0]);
            map.computeIfAbsent(ele[0], i-> new HashSet<>()).add(ele[1]);
        }
        for(int i=0;i<n;i++) {
            if(!seen[i]) {
                dfs(i,map);
                c++;
            }
        }
        return c;
    }

    public void dfs(int n, Map<Integer,Set<Integer>> map) {
        if(seen[n]) {
            return;
        }

        seen[n] = true;
        for(int ele:map.getOrDefault(n, new HashSet<>())) {
            dfs(ele, map);
        }
    }
}