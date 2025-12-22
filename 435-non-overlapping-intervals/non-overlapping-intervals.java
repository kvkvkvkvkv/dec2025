class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> {
            return Integer.compare(a[1],b[1]);
        });
        int[] top = intervals[0];
        int count = 0;
        for(int i=1;i<intervals.length;i++) {
            if(top[1]>intervals[i][0]) {
                count++;
            } else {
                top = intervals[i];
            }
        }
        return count;
    }
}