class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> temp = new ArrayList();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for(int i=0;i<intervals.length;i++) {
            if(i>0) {
                int[] top = temp.get(temp.size()-1);
                if(top[1]>=intervals[i][0]) {
                    top[1]=  Math.max(top[1], intervals[i][1]);
                } else {
                    temp.add(intervals[i]);
                }
            }  else {
                temp.add(intervals[i]);
            }
        }

        int[][] ans = new int[temp.size()][2];
        int j = 0;
        for(int[] ele:temp) {
            ans[j++] = ele;
        }
        return ans;
    }
}