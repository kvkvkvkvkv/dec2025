class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i< nums.length) {
            boolean skip = skip(nums, i);
            if(skip) {
                i++;
            } else {
                swap(i, nums);
            }
        }

        for(int in=0;in<nums.length;in++) {
            if(nums[in] != in+1) {
                return in+1;
            }
        }

        return nums.length+1;
    }

    boolean skip(int[] nums, int i) {
        return nums[i]<=0 || nums[i]-1>=nums.length || nums[i] == nums[nums[i]-1] || nums[i] == i+1;
    }

    void swap(int i, int[] nums) {
        int temp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
    }
}