class Solution {
    int l =0;
    int r =0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if((m+n)%2==0) {
            int end = ((m+n)/2)-1;
            for(int i=0;i<end;i++) {
                min(nums1, nums2);
            }
            return (double)(min(nums1, nums2)+min(nums1,nums2))/2;
        } else {
            int end = (m+n)/2;
            for(int i=0;i<end;i++) {
                min(nums1, nums2);
            }
            return (double)min(nums1,nums2);
        }
    }

    int min(int[] nums1, int[] nums2) {
        if(l == nums1.length) {
            return nums2[r++];
        } 
        if(r == nums2.length) {
            return nums1[l++];
        }
        return nums1[l]<=nums2[r]?nums1[l++]:nums2[r++];
    }
}