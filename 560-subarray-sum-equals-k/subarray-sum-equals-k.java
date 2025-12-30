class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        int count = 0;
        map.put(0,1);
        int sum = 0;
        for(int ele:nums) {
            sum+=ele;
            count += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}