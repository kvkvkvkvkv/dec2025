class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int r = n-1;
        int k = m+n-1;

        while(k>=0) {
            int one = l<0?Integer.MIN_VALUE:nums1[l];
            int two = r<0?Integer.MIN_VALUE:nums2[r];
            if(one>=two) {
                nums1[k] = one;
                l--;
            } else {
                nums1[k] = two;
                r--;
            }
            k--;
        }
    }
}