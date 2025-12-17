class Solution {
    boolean[] stack;
    boolean[] seen;
    public boolean validTree(int n, int[][] edges) {
        stack = new boolean[n];
        seen = new boolean[n];
        Map<Integer,Set<Integer>> map = new HashMap();
        for(int[] ele:edges) {
            map.computeIfAbsent(ele[1], i -> new HashSet<>()).add(ele[0]);
            map.computeIfAbsent(ele[0], i -> new HashSet<>()).add(ele[1]);
        }
        if(cycle(0, map, -1)) {
            return false;
        }

        for(boolean ele:seen) {
            if(!ele) {
                return false;
            }
        }
        return true;
    }

    boolean cycle(int ele, Map<Integer, Set<Integer>> map, int parent) {
        if(stack[ele]) {
            return true;
        }

        if(seen[ele]) {
            return false;
        }

        seen[ele] = true;
        stack[ele] = true;
        for(int val:map.getOrDefault(ele, new HashSet<>())) {
            if(val!=parent && cycle(val,map,ele)) {
                return true;
            }
        }
        stack[ele] = false;
        return false;
    }
}