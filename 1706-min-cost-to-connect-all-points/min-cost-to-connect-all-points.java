class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] seen = new boolean[points.length];
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        q.add(new Pair(0,0));

        int e = 0;
        int ans = 0;
        while(!q.isEmpty()) {
            Pair<Integer,Integer> top = q.poll();
            if(e == points.length) {
                return ans;
            }
            if(seen[top.getKey()]) {
                continue;
            }
            e++;
            ans+=top.getValue();
            seen[top.getKey()] = true;
            for(int i=0;i<points.length;i++) {
                if(!seen[i]) {
                    int dist = Math.abs(points[top.getKey()][0]-points[i][0]) +
                    Math.abs(points[top.getKey()][1]-points[i][1]); 
                    q.add(new Pair(i,dist));
                }
            }
        }
        return ans;
    }
}