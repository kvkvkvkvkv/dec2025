class Solution {
    int[] state;
    public boolean canFinish(int numCourses, int[][] pre) {
        state = new int[numCourses];
        Map<Integer,Set<Integer>> map = new HashMap();
        for(int[] ele:pre) {
            map.computeIfAbsent(ele[1], i -> new HashSet<>()).add(ele[0]);
        }
        Set<Integer> seen = new HashSet();
        for(int i=0;i<numCourses;i++) {
            if(cycle(map,i)){
                return false;
            }
        }
        return true;
    }

    boolean cycle(Map<Integer,Set<Integer>> map, int ele) {
        
        if(state[ele]==2) {
            return false;
        }

        if(state[ele]==1) {
            return true;
        }

        state[ele]=1;
        for(int val:map.getOrDefault(ele, new HashSet<>())) {
            if(cycle(map,val)) {
                return true;
            }
        }
        state[ele]=2;
        return false;
    }
}