class Solution {
    Map<Pair<Integer,Integer>,Boolean> memo = new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer,List<Integer>> map = new HashMap();
        for(int[] ele:prerequisites) {
            map.computeIfAbsent(ele[0], k -> new ArrayList()).add(ele[1]);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] ele:queries) {
            ans.add(isReach(ele[0],ele[1],map));
        }
        return ans;
    }

    boolean isReach(int start, int end, Map<Integer,List<Integer>> map) {
        if(start == end) {
            return true;
        }
        Pair<Integer,Integer> p = new Pair(start,end);
        if(memo.get(p) != null) {
            return memo.get(p);
        }
        for(int ele:map.getOrDefault(start, new ArrayList<>())) {
            if(isReach(ele, end, map)) {    
                memo.put(p, true);
                return true;
            }
        }

        memo.put(p, false);
        return false;
    }
}