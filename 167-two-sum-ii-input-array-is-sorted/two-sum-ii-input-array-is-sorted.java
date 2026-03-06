class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l<r) {
            int sum = nums[l]+nums[r];

            if(target == sum) {
                return new int[]{l+1,r+1};
            }

            if(target>sum) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }
}