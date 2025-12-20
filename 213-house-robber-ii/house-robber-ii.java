class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, nums.length-2, 0, new Integer[nums.length]), 
        rob(nums, nums.length-1, 1, new Integer[nums.length]));    
    }

    public int rob(int[] nums, int index, int start, Integer[] memo) {
        if(index<start) {
            return 0;
        }

        if(memo[index] != null) {
            return memo[index];
        }
        int leave = rob(nums, index-1, start, memo);
        int take = nums[index] + rob(nums,index-2, start, memo);
        return memo[index] = Math.max(take, leave);
    }
}