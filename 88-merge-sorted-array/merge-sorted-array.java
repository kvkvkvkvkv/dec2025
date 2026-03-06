class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int r = n-1;
        int k = m+n-1;

        while(k>=0) {
            int v1 = l<0?Integer.MIN_VALUE:nums1[l];
            int v2 = r<0?Integer.MIN_VALUE:nums2[r];

            if(v1>=v2) {
                nums1[k--] = v1;
                l--;
            } else {
                nums1[k--] = v2;
                r--;
            }
        }    
    }
}