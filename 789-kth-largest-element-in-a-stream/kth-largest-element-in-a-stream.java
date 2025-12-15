class KthLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int ele:nums) {
            q.add(ele);
            if(q.size()>k) {
                q.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        q.add(val);
        if(k<q.size()) {
            q.poll();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */