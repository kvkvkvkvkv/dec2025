class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean one = false;
        for(int ele:nums) {
            if(ele == 1) {
                one = true;
                break;
            }
        }

        if(!one) {
            return 1;
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] <= 0 || nums[i]>nums.length) {
                nums[i] = 1;
            }
        }

        for(int i=0;i<nums.length;i++) {
            int cur = Math.abs(nums[i]);
            if(cur<nums.length) {
                nums[cur] = -Math.abs(nums[cur]);
                continue;
            }

            if(cur == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            }
        }

        for(int i=1;i<nums.length;i++) {
            if(nums[i]>0) {
                return i;
            }
        }

        if(nums[0] > 0) {
            return nums.length;
        }


        return nums.length+1;
    }
}