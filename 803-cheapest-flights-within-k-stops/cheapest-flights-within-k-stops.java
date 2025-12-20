class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { 
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        Map<Integer, Map<Integer,Integer>> map = new HashMap();

        for(int[] ele:flights) {
            map.computeIfAbsent(ele[0], i -> new HashMap<>()).put(ele[1],ele[2]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.add(new Pair(src,0));
        dist[src]=0;

        int t=0;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                Pair<Integer,Integer> p = q.poll();
                if(p.getKey()==dst) {
                    ans =  Math.min(ans,p.getValue());
                }
                for(int next:map.getOrDefault(p.getKey(), new HashMap<>()).keySet()) {
                    if(dist[next]> map.get(p.getKey()).get(next) + p.getValue()) {
                        dist[next] = map.get(p.getKey()).get(next) + p.getValue();
                        q.add(new Pair(next, dist[next]));
                    }
                }
                size--;
            }
            if(t>k) {
                break;
            }
            t++;
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}