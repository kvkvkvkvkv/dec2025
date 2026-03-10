class Solution {
    public int search(int[] nums, int target) {
        int min = findMin(nums);

        int l1 = bin(nums, target, 0, min-1);
        int l2 = bin(nums, target, min, nums.length-1);

        return l1!=-1?l1:l2;

    }

    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;

        while(l<r) {
            int mid = l + (r-l)/2;
            if(nums[mid]<nums[r]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return r;
    }

    public int bin(int[] nums, int target, int l, int r) {
        while(l<=r) {
            int mid = l+(r-l)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid]>target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}