class Solution {
    boolean[] stack;
    boolean[] seen;
    int in=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        stack = new boolean[numCourses];
        seen = new boolean[numCourses];
        in = numCourses-1;
        Map<Integer, List<Integer>> map = new HashMap();

        for(int[] ele:prerequisites) {
            map.computeIfAbsent(ele[1], key -> new ArrayList<>()).add(ele[0]);
        }

        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(!seen[i] && cycle(map, i, ans)) {
                return new int[]{};
            }
        }
        return ans;
    }

    boolean cycle(Map<Integer,List<Integer>> map, int node, int[] ans) {
        if(stack[node]) {
            return true;
        }

        if(seen[node]) {
            return false;
        }

        stack[node] = true;
        seen[node]=true;
        for(int next:map.getOrDefault(node, new ArrayList<>())) {
            if(cycle(map, next, ans)) {
                return true;
            }
        }
        stack[node]=false;
        ans[in--] = node;
        return false;
    }
}