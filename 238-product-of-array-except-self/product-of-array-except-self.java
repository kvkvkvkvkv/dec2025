class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);
        for(int i=1;i<nums.length;i++) {
            prod[i] = prod[i-1] * nums[i-1]; 
        }
        int[] ans = new int[nums.length];
        int mul = 1;
        ans[nums.length-1] = prod[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) {
            ans[i] = nums[i+1]*mul*prod[i];
            mul = mul * nums[i+1];
        }

        return ans;
    }
}