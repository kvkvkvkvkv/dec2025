class Solution {
    int[] inward;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inward = new int[numCourses];

        for(int[] ele:prerequisites) {
            inward[ele[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] ele:prerequisites) {
            map.computeIfAbsent(ele[1], key->new ArrayList<>()).add(ele[0]);
        }
        for(int i=0;i<numCourses;i++) {
            if(inward[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int index=0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans[index++] = cur;
            if(map.get(cur) == null) {
                continue;
            }
            for(int ele:map.get(cur)) {
                inward[ele]--;
                if(inward[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        return index==numCourses?ans:new int[]{};
    }
}