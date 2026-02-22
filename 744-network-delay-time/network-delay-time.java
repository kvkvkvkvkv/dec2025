class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<int[]> q = new LinkedList<>();

        Map<Integer,List<Pair<Integer,Integer>>> map = new HashMap();

        for(int[] ele:times) {
            map.computeIfAbsent(ele[0], key -> new ArrayList<>()).add(new Pair(ele[1], ele[2]));
        }

        q.add(new int[]{k,0});
        int[] min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[k]=0;
        int count = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            if(map.get(top[0]) == null) {
                continue;
            }
            for(Pair<Integer,Integer> ele:map.get(top[0])) {
                int key = ele.getKey();
                int val = ele.getValue();

                if(val+top[1]<min[key]) {
                    min[key] = val+top[1];
                    q.add(new int[]{key,min[key]});
                }
            }
        }

        int m = -1;
        for(int i=1;i<=n;i++) {
            m = Math.max(min[i],m);
        }

        return m==Integer.MAX_VALUE?-1:m;
    }
}