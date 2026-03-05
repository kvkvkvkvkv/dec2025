class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int ele:nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        LinkedList<Integer>[] node = new LinkedList[nums.length+1];
        for(int key:map.keySet()) {
            int val = map.get(key);

            if(node[val] == null) {
                node[val] = new LinkedList<Integer>();
            }
            node[val].add(key);
        }
        int[] ans = new int[k];
        int e=0;
        for(int i=nums.length;i>=0;i--) {
            if(node[i] != null) {
                while(!node[i].isEmpty() && e<k) {
                    ans[e++] = (int)node[i].removeFirst();
                }
            }
            if(e==k) {
                break;
            }
        }
        return ans;
    }
}