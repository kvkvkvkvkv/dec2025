class Solution {
    boolean[] stack;
    boolean[] seen;
    int[] ans;
    int k;
    public int[] findOrder(int numCourses, int[][] pre) {
        stack = new boolean[numCourses];
        seen = new boolean[numCourses];
        ans = new int[numCourses];
        k = numCourses-1;
        Map<Integer,Set<Integer>> map = new HashMap();
        for(int[] ele:pre) {
            map.computeIfAbsent(ele[1], i -> new HashSet<>()).add(ele[0]);
        }

        for(int i=0;i<numCourses;i++) {
            if(cycle(map,i)){
                return new int[]{};
            }
        }
        return ans;
    }

    boolean cycle(Map<Integer,Set<Integer>> map, int ele) {
        if(stack[ele]) {
            return true;
        }

        if(seen[ele]) {
            return false;
        }

        seen[ele] = true;
        stack[ele] = true;
        for(int val:map.getOrDefault(ele, new HashSet<>())) {
            if(cycle(map, val)) {
                return true;
            }
        }
        ans[k--] = ele;
        stack[ele]=false;
        return false;
    }
}