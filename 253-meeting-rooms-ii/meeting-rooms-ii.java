class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));


        for(int i=0;i<intervals.length;i++) {
            if(q.isEmpty()) {
                q.add(intervals[i]);
            } else {
                if(q.peek()[1]<=intervals[i][0]) {
                    q.poll();
                }
                q.add(intervals[i]);
            }
        }
        return q.size();
    }
}