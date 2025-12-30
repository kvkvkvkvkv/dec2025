class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = max;
        for(int i=1;i<nums.length;i++) {
            int val = min;
            min = Math.min(Math.min(nums[i],nums[i] * min), nums[i]*max);
            max = Math.max(Math.max(nums[i],nums[i] * val), nums[i]*max);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}