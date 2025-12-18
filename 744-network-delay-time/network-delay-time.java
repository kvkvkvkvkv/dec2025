class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Set<Pair<Integer,Integer>>> map = new HashMap();

        for(int[] ele:times) {
            map.computeIfAbsent(ele[0],i-> new HashSet<>()).add(new Pair(ele[1],ele[2]));
        }

        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        q.add(new Pair(k,0));
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        while(!q.isEmpty()) {
            Pair<Integer,Integer> top = q.poll();
            for(var next:map.getOrDefault(top.getKey(),new HashSet<>())) {
                if(time[next.getKey()]>top.getValue()+next.getValue()) {
                    time[next.getKey()] = top.getValue()+next.getValue();
                    q.add(new Pair(next.getKey(),time[next.getKey()]));
                }
            }
        }

        int max = -1;
        for(int index=1;index<=n;index++) {
            max = Math.max(max, time[index]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}