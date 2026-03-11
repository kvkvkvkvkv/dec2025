class Solution {
    public int splitArray(int[] nums, int k) {
        int l = -1;
        int r = 0;

        for(int ele:nums) {
            l = Math.max(ele, l);
            r+=ele;
        }

        while(l<r) {
            int mid = l+(r-l)/2;

            int tot = count(mid, nums);

            if(tot>k) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    int count(int val, int[] nums) {
        int sum = 0;
        int count = 0;
        for(int ele:nums) {
            sum+=ele;
            if(sum > val) {
                count++;
                sum = ele;
            }
        }
        count++;
        return count;
    }
}