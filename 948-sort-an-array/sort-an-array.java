class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length-1);
        return nums;
    }

    public void merge(int[] nums, int l, int r) {
        if(l>=r) {
            return;
        }

        int mid = l + (r-l)/2;
        merge(nums, l, mid);
        merge(nums, mid+1, r);
        sort(nums, l, mid, r);
    }

    void sort(int[] nums, int l, int mid, int r) {
        int[] temp = new int[nums.length];

        int i = l;
        int j = mid+1;
        int k = l;

        while(i<=mid || j<=r) {
            int v1 = i>mid?Integer.MAX_VALUE:nums[i];
            int v2 = j>r?Integer.MAX_VALUE:nums[j];

            if(v1<=v2) {
                temp[k++] = nums[i++];
            } else{
                temp[k++] = nums[j++];
            }
        }

        for(int in=l;in<=r;in++) {
            nums[in] = temp[in];
        }
    }
}