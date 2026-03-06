class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int m1 = height[l];
        int m2 = height[r];
        int max = -1;
        while(l<r) {
            m1 = Math.max(m1, height[l]);
            m2 = Math.max(m2, height[r]);
            
            if(m1>=m2) {
                max = Math.max(max, (r-l) * Math.min(m1, height[r]));
                r--;
            } else {
                max = Math.max(max, (r-l) * Math.min(m2, height[l]));
                l++;
            }
        }
        return max;
    }
}