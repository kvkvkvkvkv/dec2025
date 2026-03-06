class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i=0;i<nums.length;i++) {
            while(!skip(nums,i)) {
                swap(i, nums);
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return i+1;
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