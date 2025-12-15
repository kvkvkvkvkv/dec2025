class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> {
            int first = points[a][0]*points[a][0] + points[a][1]*points[a][1];
            int second = points[b][0]*points[b][0] + points[b][1]*points[b][1];
            return Integer.compare(second,first);
        });

        for(int i=0;i<points.length;i++) {
            q.add(i);
            if(q.size()>k) {
                q.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i=0;
        while(!q.isEmpty()) {
            ans[i++] = points[q.poll()];
        }
        return ans;
    }
}