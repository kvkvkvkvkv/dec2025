class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }


        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        int median = (m+n+1)/2;
        boolean odd = (m+n)%2==1;

        while(l<=r) {

            int p1 = l+(r-l)/2;
            int p2 = median - p1;

            long l1 = p1-1<0?Integer.MIN_VALUE:nums1[p1-1];
            long r1 = p1==m?Integer.MAX_VALUE:nums1[p1];
            long l2 = p2-1<0?Integer.MIN_VALUE:nums2[p2-1];
            long r2 = p2==n?Integer.MAX_VALUE:nums2[p2];

            if(l1<=r2 && l2<=r1) {
                if(odd) {
                    return Math.max(l1,l2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) /2.0;
                }
            }

            if(l1>r2) {
                r = p1-1;
            } else {
                l = p1+1;
            }
        }
        return -1;
    }
}