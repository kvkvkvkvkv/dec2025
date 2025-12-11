class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList();
        int[] max = new int[nums.length-k+1];
        int i=0;
        for(int index=0;index<nums.length;index++) {
            while(!q.isEmpty() && index-q.getFirst()>=k) {
                q.removeFirst();
            }

            while(!q.isEmpty() && nums[index]>=nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(index);
            if(index>=k-1) {
                max[i++] = nums[q.getFirst()];
            }
        }
        return max;
    }
}