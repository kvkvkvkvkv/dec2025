class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        if(intervals.length == 0) {
            return true;
        }

        int[] top = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(top[1]>intervals[i][0]) {
                return false;
            }
            top = intervals[i];
        }

        return true;
    }
}