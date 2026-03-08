class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        int l =0;
        for(int i=0;i<nums.length;i++) {
            while (!q.isEmpty() && q.getFirst()[0]<=i-k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.getLast()[1]<=nums[i]) {
                q.removeLast();
            }
            q.add(new int[]{i,nums[i]});
            if(i>=k-1) {
                ans[l++] = q.peek()[1];
            }
        }
        return ans;
    }
}