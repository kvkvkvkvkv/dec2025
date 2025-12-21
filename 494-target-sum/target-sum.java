class Solution {
    Map<Pair<Integer,Integer>,Integer> map = new HashMap();
    public int findTargetSumWays(int[] nums, int target) {
        return sum(nums,target, 0);
    }

    public int sum(int[] nums, int target, int index) {
        if(index == nums.length) {
            return target==0?1:0;
        }
        Pair<Integer,Integer> p = new Pair(target,index);
        if(map.containsKey(p)) {
            return map.get(p);
        }
        int add = sum(nums, target-nums[index], index+1);
        int sub = sum(nums, target+nums[index], index+1);
        map.put(p,add + sub);
        return add + sub;
    }
}