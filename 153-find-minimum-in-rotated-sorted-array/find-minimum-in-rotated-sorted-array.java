class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l<r) {
            int mid = l + (r-l)/2;

            if(nums[l]<=nums[mid]) {
                if(nums[l]<=nums[r]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                r= mid;
            }
        }
        return nums[l];
    }
}