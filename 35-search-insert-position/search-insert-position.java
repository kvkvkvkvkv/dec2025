class Solution {
    public int searchInsert(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;

        while(l<r) {
            int mid = l+(r-l)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid]>target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return target>nums[nums.length-1]?l+1:l;
    }
}