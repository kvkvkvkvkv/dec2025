class Solution {
    public int maxProduct(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int prev = 1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                left[i]=0;
                prev = 1;
            } else {
                prev = prev * nums[i];
                left[i] = prev;
            }
        }

        prev = 1;
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]==0) {
                right[i]=0;
                prev = 1;
            } else {
                prev = prev * nums[i];
                right[i] = prev;
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            int t = Math.max(left[i], right[i]);
            ans = Math.max(t,ans);
        }

        return ans;
        
    }
}