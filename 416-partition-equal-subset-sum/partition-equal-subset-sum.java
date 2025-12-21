class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele:nums) {
            sum+=ele;
        }

        if(sum%2==1) {
            return false;
        }

        sum=sum/2;
        memo = new Boolean[nums.length+1][sum+1];
        return part1(nums, sum, 0);
    }

    boolean part1(int[]nums, int sum, int index) {
        if(index == nums.length) {
            return sum==0;
        }

        if(memo[index][sum] != null) {
            return memo[index][sum];
        }

        boolean leave = part1(nums, sum, index+1);
        boolean take = false;

        if(sum-nums[index]>=0) {
            if(part1(nums, sum-nums[index], index+1)) {
                take = true;
                return memo[index][sum] = true;
            }
        }

        return memo[index][sum] = leave || take;
    }

    
}