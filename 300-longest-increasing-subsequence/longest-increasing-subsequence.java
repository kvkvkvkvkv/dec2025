class Solution {
    Integer[][] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new Integer[nums.length][nums.length];
        return lis(nums, 0, -1);
    }

    public int lis(int[] nums, int index, int prev) {
        if(index == nums.length) {
            return 0;
        }

        if(prev!=-1 && memo[index][prev]!=null) {
            return memo[index][prev];
        } 

        int leave = lis(nums, index+1, prev);
        int take = 0;
        if(prev==-1 || nums[prev]<nums[index]) {
            take = 1 + lis(nums, index+1, index);
        } 

        if(prev == -1) {
            return Math.max(take, leave);
        }
        return memo[index][prev] = Math.max(take, leave);
    }
}