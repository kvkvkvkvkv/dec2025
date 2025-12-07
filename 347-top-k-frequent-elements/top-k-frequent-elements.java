class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap();

        for(int ele:nums) {
            count.putIfAbsent(ele, 0);
            count.put(ele, count.get(ele)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue((a,b) -> 
        Integer.compare(count.get(a), count.get(b)));

        for(int key:count.keySet()) {
            minHeap.add(key);
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(minHeap.size()>0){
            ans[i++]= minHeap.poll();
        }

        return ans;

    }
}