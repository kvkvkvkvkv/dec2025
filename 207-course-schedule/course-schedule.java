class Solution {
    boolean[] stack;
    boolean[] seen;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        stack = new boolean[numCourses];
        seen = new boolean[numCourses];

        Map<Integer, List<Integer>> map = new HashMap();

        for(int[] ele:prerequisites) {
            map.computeIfAbsent(ele[1], key -> new ArrayList<>()).add(ele[0]);
        }

        for(int i=0;i<numCourses;i++) {
            if(!seen[i] && cycle(map, i)) {
                return false;
            }
        }
        return true;
    }

    boolean cycle(Map<Integer,List<Integer>> map, int node) {
        if(stack[node]) {
            return true;
        }

        if(map.get(node) == null || seen[node]) {
            return false;
        }

        stack[node] = true;
        seen[node]=true;
        for(int next:map.get(node)) {
            if(cycle(map, next)) {
                return true;
            }
        }
        stack[node]=false;
        return false;
    }
}