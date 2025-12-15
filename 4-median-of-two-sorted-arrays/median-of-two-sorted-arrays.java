class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l =0;
        int r =0;
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m+n];
        int i=0;

        while(l<m || r<n) {
            if(l == m ) {
                temp[i++] = nums2[r++];
            } else if(r == n) {
                temp[i++] = nums1[l++];
            } else if(nums2[r]<=nums1[l]) {
                temp[i++] = nums2[r++];
            } else {
                temp[i++] = nums1[l++];
            }
        }

        int mid = (m+n)/2;
        if((m+n) % 2 == 1) {
            return temp[mid];
        }
        return (double)(temp[mid] + temp[mid-1])/2;
    }
}