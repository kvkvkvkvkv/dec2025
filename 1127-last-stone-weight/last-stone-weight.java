class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int ele:stones) {
            q.add(ele);
        }

        while(q.size()>=2) {
            int v1 = q.poll();
            int v2 = q.poll();
            if(v1 != v2) {
                q.add(v1-v2);
            } 
        }

        return q.isEmpty()?0:q.poll();
    }
}