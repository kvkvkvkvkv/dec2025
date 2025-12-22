class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        List<int[]> p = new ArrayList();

        for(int i=0;i<queries.length;i++) {
            p.add(new int[]{i,queries[i]});
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        Collections.sort(p, (a,b) -> Integer.compare(a[1],b[1]));
        int[] ans = new int[queries.length];
        int i=0;
        for(int[] ele:p) {
            while(i<intervals.length && intervals[i][0]<=ele[1]) {
                q.add(new int[]{intervals[i][1]-intervals[i][0]+1, intervals[i][1]});
                i++;
            }

            while(!q.isEmpty() && q.peek()[1]<ele[1]) {
                q.poll();
            }

            if(q.size() == 0) {
                ans[ele[0]] = -1;
            } else {
                ans[ele[0]] = q.peek()[0];
            }
        }

        return ans;
    }
}