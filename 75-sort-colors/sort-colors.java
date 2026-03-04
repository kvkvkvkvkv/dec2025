class Solution {
    public void sortColors(int[] nums) {
        int i= 0;
        int j = 0;
        int k = nums.length-1;

        while(i<k && j<=k) {
            if(nums[i] == 0) {
                i++;
                continue;
            }

            if(nums[k] == 2) {
                k--;
                continue;
            }

            if(nums[j] == 1) {
                j++;
                continue;
            }

            if(j<i) {
                j =i;
                continue;
            }

            if(nums[j] == 2) {
                swap(k,j,nums);
                k--;
                continue;
            }

            if(nums[j] == 0) {
                swap(i,j,nums);
                i++;
                continue;
            }
        }
    }

    public void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}